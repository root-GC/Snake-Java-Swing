package Snake;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.Timer;
import java.util.Random;

public class Cenario extends JFrame implements KeyListener{
	//Componentes a utilizar
	JButton snake = new JButton();
	JPanel painel = new JPanel();
	JButton start = new JButton("START");
	
	private Timer timer;
	private int estado = 0;
	
	/// Pega a posição atual do botão
	//Rectangle bounds = snake.getBounds();
	//int x = bounds.x;
	//int y = bounds.y;
	//int x; int y;
	
	// Cria uma instância de Random
        Random random;
	
	//Pega a posição do rectangulo/campo(onde a snake anda)
	
	Rectangle campo = painel.getBounds();
	int campox=0;
	int campoy=0;
	int campoWidth=0;
	int campoHeight=0;
	
	
	//Limites da snake
		
	Rectangle cobra = snake.getBounds();	
	int cobraX=0;
	int cobraY=0;
	int cobraHeight=0;
	int cobraWidth=0;
	//Random
	JButton Aleatorio = new JButton();
	
	public Cenario()//Inicializar configurancoes da tela
	{
		//System.out.println("X= "+campox+"   Y= "+campoy);
		//System.out.println("Rodando!");
		this.setSize(900,600);//larguta x altura
		//this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setLayout(new FlowLayout());
		//this.setLayout(new GridLayout(1,2,1,1));
		this.setLayout(null);
		this.setTitle("Game Snake");
		
		// Solicita foco para capturar eventos de teclado
        this.setFocusable(true);
        this.requestFocusInWindow();
		this.requestFocus();            // Pede foco completo para o JFrame
		
		//chamadas
		this.addKeyListener(this);
		Painel();
		Snake();
		
		//Random
		
        Aleatorio.setBackground(new Color(242,174,48)); // Cor do objeto
        Aleatorio.setBounds(10, 0, 20, 20); // Tamanho inicial
        //painel.add(Aleatorio);
        
       random = new Random();
        
        // Chama o método para posicionar o objeto aleatoriamente
        posicionarObjetoAleatorio();
		
		ShowIt();
		
		//Inicia o jogo
		botaoStart();
		
		// Configura o timer com intervalo de 200 ms para controlar a velocidade
        timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move(estado);
				//System.out.println(" X= "+campox+"   Y= "+campoy+" H= "+campoHeight+"  W = "+campoWidth);
				colisao();
				
				//Actualizacao da posicao da snake
				//cobraX = snake.getX();
				//cobraY = snake.getY();
				//cobraHeight = snake.getHeight();
				//cobraWidth = snake.getWidth();
            }
        });	
		//timer.start(); // Inicia o timer para mover a Snake continuamente
	}
	 
	private void posicionarObjetoAleatorio() {
		painel.add(Aleatorio);
        // Gera posições aleatórias dentro do painel
        int x = random.nextInt(/*campoWidth*/600 - 50);  // Subtrai 50 para garantir que o objeto fique dentro do painel
        int y = random.nextInt(/*campoHeight*/400 - 50);   // Subtrai 50 para garantir que o objeto fique dentro do painel   
        // Define a nova posição do objeto
        Aleatorio.setLocation(x, y);
    }
		
	
	public void configurarBotaoSnake() {
		
		
        // Configurações adicionais para o botão
        //snake.setPreferredSize(new Dimension(20, 20));  // Tamanho do botão
		snake.setLayout(null);
		snake.setBounds(194, 6, 50, 50);    // Define a posição e o tamanho da "snake"
        snake.setBackground(new Color(167,114,242));                // Cor de fundo
        //snake.setForeground(Color.BLACK);                // Cor do texto
        //snake.setFont(new Font("Arial", Font.BOLD, 16)); // Fonte do texto
		// Define posição inicial no centro do painel
       // x = (painel.getWidth() - snake.getPreferredSize().width) / 2;
       // y = (painel.getHeight() - snake.getPreferredSize().height) / 2;
       // snake.setLocation(x, y);
		
    }
	public void botaoStart()//Botao start
	{
		//start.setPreferredSize(new Dimension(80, 50));  // Tamanho do botão
        start.setBackground(new Color(23,174,191)); 
		start.setBounds(193, 420, 80, 50);   // Define a posição e o tamanho do botão "start"
		this.add(start);
	}
	public void ShowIt()//Mostrar o que foi desenhado no frame
	{
		this.setVisible(true);
		this.validate();
		//Busca as cordenadas do painel e da snake
		//Rectangle cobra = snake.getBounds();
		//Rectangle campo = painel.getBounds();
		//Recalcular as dimencoes do painel
		actualizarCoordenadas();
		
		
	}
	
	
	 private void actualizarCoordenadas() 
	 {
		Rectangle campo = painel.getBounds();//Buscar as cordenadas no momento que voce quiser utiliar as cordenadas
		Rectangle cobra = snake.getBounds();
		
        campox = campo.x;
        campoy = campo.y;
        campoWidth = campo.width;
        campoHeight = campo.height;
		System.out.println("X = "+campo.x+" Y= "+campo.y+" LARGURA = "+campo.width+" Altura = "+campo.height);
		System.out.println("X cobra = "+cobra.x+"Y cobra = "+cobra.y);
        //x = (campoWidth - snake.getWidth()) / 2;
       // y = (campoHeight - snake.getHeight()) / 2;/////////////////////////////////////////////////////////////////////problema
		cobraX = cobra.x;
		cobraY = cobra.y;

       // cobraX = x;
       // cobraY = y;
		//snake.setLocation(200, 20);
		snake.setBounds(((campoWidth-50)/2), ((campoHeight-50)/2), 50, 50);  
	}
	//JPanel 
	public void Painel()
	{
		painel.setBackground(new Color(40,57,89));  
        painel.setBorder(new LineBorder(new Color(42,191,149), 4));  
        //painel.setPreferredSize(new Dimension(500, 400));  //Largura e Altura
		painel.setLayout(null);
		painel.setBounds(193, 5, 500, 400);  // Define a posição e o tamanho do painel
		Rectangle campo = painel.getBounds();
		this.add(painel);
	}
	//Manipulando os Componentes
	public void Snake()
	{
		configurarBotaoSnake();
		//snack.addE
		//snake.setLocation(200, 20);
		//snake.setBounds(((campoWidth-50)/2), ((campoHeight-50)/2), 50, 50);  
		//snake.setBounds(194, 7, 50, 50);  
		painel.add(snake);
	}
	


    public void keyPressed(KeyEvent e) {
        System.out.println("Clicou: " + e.getKeyCode());
        // Define o estado para a direção atual
        estado = e.getKeyCode();
		if(e.getKeyCode()==32){
			estado=40;
			timer.start(); // Inicia o timer para mover a Snake continuamente
		}
    }

    public void keyReleased(KeyEvent e) {
        // A Snake continuará se movendo na direção definida no último `estado`
    }

    public void move(int opcao) {
        switch (opcao) {
            case 38: // Cima
                cobraY -= 4;
                break;
            case 40: // Baixo
                cobraY += 4;
                break;
            case 37: // Esquerda
                cobraX -= 4;
                break;
            case 39: // Direita
                cobraX += 4;
                break;
            default:
                return; // Sai do método se não houver direção definida
        }
        snake.setLocation(cobraX, cobraY);
    }
	public void colisao()
	{
		System.out.println("Limite Inferior 405: " + (campoy + campoHeight) + " Snake: " + (cobraY + cobraHeight));
		System.out.println("Limite Superior 5: " + campoy + " Snake: " + cobraY);
		System.out.println("Limite Esquerdo 193: " + campox + " Snake: " + cobraX);
		System.out.println("Limite Direito 693: " + (campox + campoWidth) +" Snake: "+(cobraX+cobraWidth));

		if(cobraX <= 0){
			System.out.println("Colicao com a borda Esquerda");
			JOptionPane.showMessageDialog(this, "Game Over!","Tela de Game over",JOptionPane.ERROR_MESSAGE);
			timer.stop();
			return;
		}
		if(cobraY <= /*campoy*/ 5 ){
			System.out.println("Colisao com a borda superior");
			JOptionPane.showMessageDialog(this, "Game Over!","Tela de Game over",JOptionPane.ERROR_MESSAGE);
			timer.stop();
			return;
		}
		if ((cobraX + cobraWidth) >= /*(campox + campoWidth)*/ 447) {
			System.out.println("Colisão com a borda direita!");
			JOptionPane.showMessageDialog(this, "Game Over!","Tela de Game over",JOptionPane.ERROR_MESSAGE);
			timer.stop();
			return;
		}
		 if ((cobraY + cobraHeight) >= 350) {
			System.out.println("Colisão com a borda inferior!");
			JOptionPane.showMessageDialog(this, "Game Over!","Tela de Game over",JOptionPane.ERROR_MESSAGE);
			timer.stop();
			return;
		}
	}
	
	public void keyTyped(KeyEvent e2){}

}