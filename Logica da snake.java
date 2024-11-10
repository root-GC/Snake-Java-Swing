int tam = 50;
JButton snake[] = new JButton[tam];

public void defSnake()
{
	for(int i=0; i<tam; i++){
		if(i==0)
			snake[i]=new JButton("B"+(i+1));
		else
			snake[i]=new JButton("B"+(0));
	}
}
public void move()
{
	anteriorX=X;
	anteriorY=Y;
	/*
	@Codigo para movimentacao da snake
	.
	.
	.
	*/
	snake[0].setLocation(X,Y);
}
public void tailPosition()
{
	for(JButton conteiner: snake){
		if(conteiner.getText().equals("B0"))
			conteiner.setLocation()
	}
	
}