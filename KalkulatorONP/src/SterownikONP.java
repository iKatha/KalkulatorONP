
	public class SterownikONP {

		/**
		 * sprawdzenie priorytetu znaku
		 * @param znak jaki znak ma priorytet
		 * @return priorytet znaku
		 */
		private int wyznaczPriorytet(String znak)
		{
			switch (znak)
	        {	
				case "(": return 0;
		        case "+": return 1;
		        case "-": return 1;
		        case "x": return 2;
		        case "/": return 2;
		        case "%": return 2;
		        case "^": return 3;
		        case "v": return 3;
		        case "!": return 4;
	        }
	        return 0;
		}
		
		/**
		 * Metoda zamieniajaca wyrazenia na ONP
		 * return wyrazenie w ONP
		 * @throws Exception 
		 */
		public String zamienNaONP(String wyrazenie) throws Exception
		{
			String onp="";
			if ((wyrazenie.charAt(wyrazenie.length()-1))!= '=')
				throw new Exception("Brak znaku '=' na koncu wyra¿enia.");
			else
			{
				Stos<String> stos = new Stos<String>();
				for (int i = 0 ; i <wyrazenie.length(); i++)
				{
					//w zaleznosci od wczytanego znaku dodaj na stos, zdejmij ze stosu lub przepisz na wyjscie
					switch (wyrazenie.charAt(i))
					{
						case '(': 
						{
							stos.push(Character.toString(wyrazenie.charAt(i)));
							break;
						}
						
						case ')':
						{
							while(!stos.top().equals("(")) //dopoki na gorze stosu nie jest znak otwierajacy nawias to zdejmuj operatory ze stosu
								onp += stos.pop(); 
							stos.pop(); //zdejmij operator ( bez wpisywania go na wyjscie
							break;
						}
							
						case '+': ;
						case '-': ;
						case 'x': ;
						case '/': ;
						case '%': ;
						case '^': ;
						case 'v': ;
						case '!':
						{
							//jesli stos jest pusty lub priorytet pobieranego operatora jest wyzszy niz priorytet operatora na stosie to dodaj operator na stos
							if(stos.isEmpty() || wyznaczPriorytet(Character.toString(wyrazenie.charAt(i)))>wyznaczPriorytet(stos.top()))
							{
								stos.push(Character.toString(wyrazenie.charAt(i)));
							}
							//w przeciwnym razie zdejmuj ze stosu wszystkie operatory z priorytetem wyzszym lub rownym od pobieranego i dodaj operator na stos
							else
							{
								while(!stos.isEmpty() && wyznaczPriorytet(stos.top())>=wyznaczPriorytet(Character.toString(wyrazenie.charAt(i))))
								{
									onp += stos.pop();
									onp += " ";
								}
								stos.push(Character.toString(wyrazenie.charAt(i)));
							}
							break;
						}
						
						case '=':
						{
							// znak rownosci oznacza zakonczenie rownania wiec zdejmujemy ze stosu wszystkie znaki
							while(!stos.isEmpty())
								onp += stos.pop();
							onp += " =";
							break;
						}
						
						default:
							//liczby przepisujemy od razu na wyjscie
							onp += wyrazenie.charAt(i);
							//jesli po cyfrze znajduje sie kolejna cyfra lub kropka to nie dajemy spacji, tak aby utworzyla sie liczba
							if (!((wyrazenie.charAt(i+1)>='0' && wyrazenie.charAt(i+1)<='9') || wyrazenie.charAt(i+1)=='.'))
								onp += " ";
					}
				}
			}
			return onp;
			
		}
		
		/**
		 * obliczanie wyrazenia ONP
		 * @return wynik 
		 */
		public double obliczONP(String onp) throws ArithmeticException
		{
			double wynik = 0.0;
			//jesli wyrazenie onp nie jest puste to wykonuj obliczanie
			if (onp != "")
			{
				Stos<String> stos = new Stos<String>();
				double a;
				double b;
				String c="";
				for (int i=0; i<onp.length(); i++)
				{
					switch (onp.charAt(i))
					{
					case ' ': break;
					case '=': break;
					//jesli na wyjsciu znajduje sie ktorys z operatorow to zdejmujemy ze stosu dwie liczby i wykonujemy na nich odpowiednie dzialanie
					case '+': 
					{
						a = Double.parseDouble(stos.pop());
						b = Double.parseDouble(stos.pop());
						stos.push(Double.toString(b+a));
						break;
					}
					case '-': 
					{
						a = Double.parseDouble(stos.pop());
						b = Double.parseDouble(stos.pop());
						stos.push(Double.toString(b-a));
						break;
					}
					case 'x': 
					{
						a = Double.parseDouble(stos.pop());
						b = Double.parseDouble(stos.pop());
						stos.push(Double.toString(b*a));
						break;
					}
					case '/': 
					{
						a = Double.parseDouble(stos.pop());
						b = Double.parseDouble(stos.pop());
						
						if (a==0)
						{
							throw new ArithmeticException("Dzielenie przez zero");
						}
						else 
						{
							stos.push(Double.toString(b/a));
						}		
						break;
					}
					case '%': 
					{
						a = Double.parseDouble(stos.pop());
						b = Double.parseDouble(stos.pop());
						stos.push(Double.toString(b%a));
						break;
					}
					case '^': 
					{
						a = Double.parseDouble(stos.pop());
						b = Double.parseDouble(stos.pop());
						stos.push(Double.toString(Math.pow(b,a)));
						break;
					}
					case 'v': 
					{
						a = Double.parseDouble(stos.pop());
						b = Double.parseDouble(stos.pop());
						stos.push(Double.toString(Math.pow(b,1/a)));
						break;
					}
					case '!':
					{
						a = Double.parseDouble(stos.pop());
						stos.push(silnia(a) + "");
						break;
					}
					//liczby dodajemy na stos
					default:
					{	
						c+=onp.charAt(i);
						if (!((onp.charAt(i+1)>='0' && onp.charAt(i+1)<='9') || onp.charAt(i+1)=='.'))
						{
							stos.push(c);
							c="";
						}
					}
					
					}
				}
				wynik = Double.parseDouble(stos.top());
			}
			
			return wynik;
		}
		
		/**
		 * Metoda obliczajaca silnie
		 * @return silnia
		 */
		private double silnia(double l)
		{
			double silnia = 1;
			for (int i = 0; i<l ; i++)
			{
				silnia*=(i+1);
			}
			return silnia; 
		}
	}

