package com.subirtupagina.diversioneskavier;

public class Guess {

	String word[] = new String[30];
	String type;
	public void animals(String selected){
		
		if( selected == "English"){
			type="ANIMALS";
			word[0]="DOG";
			word[1]="COW";
			word[2]="BIRD";
			word[3]="CAT";
			word[4]="HORSE";
			word[5]="FISH";
			word[6]="MONKEY";
			word[7]="DONKEY";
			word[8]="EAGLE";
			word[9]="PIG";
			word[10]="BEAR";
			word[11]="LION";
			word[12]="TIGER";
			word[13]="RABBIT";
			word[14]="SNAKE";
			word[15]="TURTLE";
			word[16]="WHALE";
			word[17]="SHARK";
			word[18]="JELLYFISH";
			word[19]="MANTA RAY";
		}
		else if( selected == "Spanish" ){
			type="ANIMALES";
			word[0]="PERRO";
			word[1]="VACA";
			word[2]="PAJARO";
			word[3]="GATO";
			word[4]="CABALLO";
			word[5]="PEZ";
			word[6]="CHANGO";
			word[7]="BURRO";
			word[8]="AGUILA";
			word[9]="PUERCO";
			word[10]="OSO";
			word[11]="LEON";
			word[12]="TGRE";
			word[13]="CONEJO";
			word[14]="SERPIENTE";
			word[15]="TORTUGA";
			word[16]="BALLENA";
			word[17]="TIBURON";
			word[18]="MEDUSA";
			word[19]="MANTARRAYA";
		}
		
	}
	public void movies(String selected){
		if( selected == "English"){
			type="MOVIES";
			word[0]="THE DARK KNIGHT";
			word[1]="THE GODFATHER";
			word[2]="UP";
			word[3]="THE AVENGERS";
			word[4]="IRONMAN";
			word[5]="INCEPTION";
			word[6]="SKYFALL";
			word[7]="SHERLOCK HOLMES";
			word[8]="STAR WARS";
			word[9]="INDIANA JONES";
			word[10]="BRAVE";
			word[11]="ICE AGE";
			word[12]="TERMINATOR";
			word[13]="WATCHMEN";
			word[14]="THE SHINING";
			word[15]="THOR";
			word[16]="FORREST GUMP";
			word[17]="WALL E";
			word[18]="LION KING";
			word[19]="HANGOVER";
		}
		else if( selected == "Spanish" ){
			type="PELICULAS";
			word[0]="BATMAN";
			word[1]="EL PADRINO";
			word[2]="UP";
			word[3]="LOS VENGADORES";
			word[4]="IRONMAN";
			word[5]="EL ORIGEN";
			word[6]="SKYFALL";
			word[7]="SHERLOCK HOLMES";
			word[8]="STAR WARS";
			word[9]="INDIANA JONES";
			word[10]="VALIENTE";
			word[11]="ERA DEL HIELO";
			word[12]="TERMINATOR";
			word[13]="VIGILANTES";
			word[14]="EL RESPLANDOR";
			word[15]="THOR";
			word[16]="FORREST GUMP";
			word[17]="WALL E";
			word[18]="EL REY LEON";
			word[19]="QUE PASO AYER";
		}
	}
	public void sports(String selected){
		if( selected == "English"){
			type="SPORTS";
			word[0]="GOLF";
			word[1]="SOCCER";
			word[2]="TENNIS";
			word[3]="VOLEYBALL";
			word[4]="BASEBALL";
			word[5]="CRICKET";
			word[6]="HOCKEY";
			word[7]="FENCING";
			word[8]="MOTORSPORTS";
			word[9]="WRESTLING";
			word[10]="RUGBY";
			word[11]="KARATE";
			word[12]="SOFTBALL";
			word[13]="DIVING";
			word[14]="BASKETBALL";
			word[15]="MARTIAL ARTS";
			word[16]="SWIMMING";
			word[17]="BOXING";
			word[18]="WINDSURF";
			word[19]="SKIING";
		}
		
		else if( selected == "Spanish" ){
			type="DEPORTES";
			word[0]="GOLF";
			word[1]="FUTBOL";
			word[2]="TENIS";
			word[3]="VOLYBOLL";
			word[4]="BEISBOL";
			word[5]="CRIQUET";
			word[6]="JOQUI";
			word[7]="FENCING";
			word[8]="MOTORSPORTS";
			word[9]="WRESTLING";
			word[10]="RUGBY";
			word[11]="KARATE";
			word[12]="SOFTBALL";
			word[13]="CLAVADOS";
			word[14]="BASQUETBALL";
			word[15]="ARTES MARCIALES";
			word[16]="NATACION";
			word[17]="BOX";
			word[18]="SURF A VELA";
			word[19]="ESQUI";
		}
	}
	public void artist(String selected){
		if( selected == "English"){
			type="ARTIST";
		}
		
		else if( selected == "Spanish" ){
			type="ARTISTAS";
		}
			word[0]="ANTOHNY HOPKINS";
			word[1]="MORGAN FREEMAN";
			word[2]="JOHNNY DEPP";
			word[3]="WILL SMITH";
			word[4]="MEGAN FOX";
			word[5]="NICHOLAS CAGE";
			word[6]="BRUCE WILLIS";
			word[7]="ROBERT DE NIRO";
			word[8]="TOM HANKS";
			word[9]="MATT DAMON";
			word[10]="BRAD PITT";
			word[11]="JULIA ROBERTS";
			word[12]="NICOLE KIDMAN";
			word[13]="ROBERT DOWNEY";
			word[14]="TOM CRUISE";
			word[15]="SANDRA BULLOCK";
			word[16]="AL PACINO";
			word[17]="EMMA WATSON";
			word[18]="ROBERT DUVALL";
			word[19]="JIM CARREY";
	}
	public void colors(String selected){
		if( selected == "English"){
			type="COLORS";
			word[0]="BLUE";
			word[1]="RED";
			word[2]="BLACK";
			word[3]="YELLOW";
			word[4]="WHITE";
			word[5]="GREEN";
			word[6]="GRAY";
			word[7]="BEIGE";
			word[8]="BROWN";
			word[9]="VIOLET";
			word[10]="CYAN";
			word[11]="FUCHSIA";
			word[12]="GOLD";
			word[13]="PINK";
			word[14]="MAGENTA";
			word[15]="MAROON";
			word[16]="ORANGE";
			word[17]="PURPLE";
			word[18]="SILVER";
			word[19]="NAVY BLUE";
		}
		
		else if( selected == "Spanish" ){
			type="COLORES";
			word[0]="AZUL";
			word[1]="ROJO";
			word[2]="NEGRO";
			word[3]="AMARILLO";
			word[4]="BLANCO";
			word[5]="VERDE";
			word[6]="GRIS";
			word[7]="BEIGE";
			word[8]="CAFE";
			word[9]="VIOLETA";
			word[10]="CIAN";
			word[11]="FUCSIA";
			word[12]="DORADO";
			word[13]="ROSA";
			word[14]="MAGENTA";
			word[15]="MARRON";
			word[16]="NARANJA";
			word[17]="PURPURA";
			word[18]="PLATEADO";
			word[19]="AZUL MARINO";
		}
	}
	public void countries(String selected){
		if( selected == "English"){
			type="COUNTRIES";
			word[0]="MEXICO";
			word[1]="UNITED STATES";
			word[2]="GERMANY";
			word[3]="TURKEY";
			word[4]="THAILAND";
			word[5]="RUSSIA";
			word[6]="UKRAINE";
			word[7]="MALAYSIA";
			word[8]="UNITED KINGDOM";
			word[9]="CHINA";
			word[10]="JAPAN";
			word[11]="FRANCE";
			word[12]="ITALY";
			word[13]="GREECE";
			word[14]="SINGAPORE";
			word[15]="NETHERLANDS";
			word[16]="POLAND";
			word[17]="CANADA";
			word[18]="SAUDI ARABIA";
			word[19]="BRAZIL";
		}
		
		else if( selected == "Spanish" ){
			type="PAISES";
			word[0]="MEXICO";
			word[1]="ESTADO UNIDOS";
			word[2]="ALEMANIA";
			word[3]="TURQUIA";
			word[4]="TAILANDIA";
			word[5]="RUSIA";
			word[6]="UCRANIA";
			word[7]="MALASIA";
			word[8]="REINO UNIDO";
			word[9]="CHINA";
			word[10]="JAPON";
			word[11]="FRANCIA";
			word[12]="ITALIA";
			word[13]="GRECIA";
			word[14]="SINGAPUR";
			word[15]="HOLANDA";
			word[16]="POLONIA";
			word[17]="CANADA";
			word[18]="ARABIA SAUDITA";
			word[19]="BRASIL";
		}
	}
	public void food(String selected){
		if( selected == "English"){
			type="FOOD";
			word[0]="PIZZA";
			word[1]="HAMBURGUER";
			word[2]="TACO";
			word[3]="FRIED CHICKEN";
			word[4]="RICE SALAD";
			word[5]="BUFFALO WINGS";
			word[6]="BARBECUE RIBS";
			word[7]="APPLE PIE";
			word[8]="HOT DOG";
			word[9]="STEAK";
			word[10]="HAM";
			word[11]="SANDWICH";
			word[12]="FISH SOUP";
			word[13]="SHRIMPS";
			word[14]="DOUGHNUTS";
			word[15]="CELERY SALAD";
			word[16]="CRAB BISQUE";
			word[17]="NOODLE SOUP";
			word[18]="PAELLA";
			word[19]="COD";
		}
		
		else if( selected == "Spanish" ){
			type="COMIDA";
			word[0]="PIZZA";
			word[1]="HAMBURGUESA";
			word[2]="TACOS";
			word[3]="POLLO FRITO";
			word[4]="POZOLE";
			word[5]="PICADILLO";
			word[6]="COSTILLA BBQ";	 
			word[7]="PASTEL";
			word[8]="PERRO CALIENTE";
			word[9]="BISTECK";
			word[10]="JAMON";
			word[11]="EMPAREDADO";
			word[12]="SOPA DE PESCADO";
			word[13]="CAMARONES";
			word[14]="CHURROS";
			word[15]="CEVICHE";
			word[16]="ENCHILADAS";
			word[17]="SOPA DE FIDEO";
			word[18]="PAELLA";
			word[19]="BACALAO";
		}
	}
	public void brand(String selected){
		if( selected == "English"){
			type="BRAND";
		}
		else if( selected == "Spanish" ){
			type="MARCAS";
		}
			word[0]="COCA COLA";
			word[1]="SAMSUNG";
			word[2]="NIKE";
			word[3]="ADIDAS";
			word[4]="DIOR";
			word[5]="WINGS ARMY";
			word[6]="APPLE";
			word[7]="GOOGLE";
			word[8]="FACEBOOK";
			word[9]="BURGUER KING";
			word[10]="STARBUCKS";
			word[11]="COLGATE";
			word[12]="HEIKEN";
			word[13]="LOUSI VUITTON";
			word[14]="VERSACE";
			word[15]="LEGO";
			word[16]="PEPSI";
			word[17]="REBOOK";
			word[18]="GUCCI";
			word[19]="CHANNEL";
	}
		
}

