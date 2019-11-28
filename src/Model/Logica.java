package Model;

import java.util.ArrayList;
import java.util.ListIterator;

import processing.core.PApplet;

public class Logica{
	
	private PApplet app;
	private ArrayList<Organismo> organismos;
	private static ListaOrganismos lista;
	private String[] infoArchivo;
	private int ciclos=0;
	private boolean corre = true;
	private int numOrganismosT1M=0;
	private int numOrganismosT2M=0;
	private int numOrganismosT3M=0;
	private int numOrganismosT1F=0;
	private int numOrganismosT2F=0;
	private int numOrganismosT3F=0;
	
	public Logica (PApplet app) {
		
		this.app = app;
		organismos = new ArrayList<Organismo>();
		infoArchivo = app.loadStrings("info/informacion.txt");
		lista = new ListaOrganismos();
		
		//se carga la informacion de los organismos
		for(int i=0; i<infoArchivo.length;i++) {
			String[] infoOrganismo = infoArchivo[i].split(",");
			
			//se obtiene la informacion del organismo
			int tipo = Integer.parseInt(infoOrganismo[0]);
			String estado = infoOrganismo[1];
			int edad = Integer.parseInt(infoOrganismo[2]);
			String sexo = infoOrganismo[3];
			int velocidad = Integer.parseInt(infoOrganismo[4]);
			Organismo org = null;
			
			switch (tipo) {
			case 1:
				org = new Tipo1(app,estado,edad,sexo,velocidad);
				if(sexo.equals("M")) {
					numOrganismosT1M++;
				}else {
					numOrganismosT1F++;
				}
				
				break;
			case 2:
				org = new Tipo2(app,estado,edad,sexo,velocidad);
				if(sexo.equals("M")) {
					numOrganismosT2M++;
				}else {
					numOrganismosT2F++;
				}
				break;
			case 3:
				org = new Tipo3(app,estado,edad,sexo,velocidad);
				if(sexo.equals("M")) {
					numOrganismosT3M++;
				}else {
					numOrganismosT3F++;
				}
				break;
			}
			new Thread(org).start();
			organismos.add(org);
			lista.adicionar(org);
						
			new Thread(() -> {
				while(corre) {
					try {
						Thread.sleep(1000);
						ciclos++;
						
						ListIterator<Organismo> iter = this.organismos.listIterator();					
						
						while(iter.hasNext()) {
							Organismo organismo  = iter.next();
							
							if(organismo.getEstado().equals("vivo")) {
								organismo.setEdad(organismo.getEdad()+1);
								
								if(organismo instanceof Tipo1) {
									if(organismo.getEdad() == 50) {
										organismo.setEstado("muerto");
										organismo.setImagen(app.loadImage("images/Tipo1D.png"));
									}
								}
								
								if(organismo instanceof Tipo2 ) {
									if(organismo.getEdad() == 20) {
										organismo.setEstado("muerto");
										organismo.setImagen(app.loadImage("images/Tipo2D.png"));
									}
								}
								
								if(organismo instanceof Tipo3 ) {
									if(organismo.getEdad() == 120) {
										organismo.setEstado("muerto");
										organismo.setImagen(app.loadImage("images/Tipo3D.png"));
									}
								}
								
								ListIterator<Organismo> iter2 = this.organismos.listIterator();
								
								while(iter2.hasNext()) {
									
									Organismo organismo2 = iter2.next();
									
									if(!organismo.equals(organismo2)) {
										if(PApplet.dist(organismo.getPosX(), organismo.getPosY(), organismo2.getX(), organismo2.getY()) <= 50) {
											System.out.println("Colisionan");
											if(!validar(organismo, organismo2)){
												
												if(ciclos%2==0) {
													Organismo orgNuevo = new Tipo1(this.app, "vivo", 0, "M", 15);
													iter.add(orgNuevo);
													new Thread(orgNuevo).start();					
													this.numOrganismosT1M++;
												}else {
													Organismo orgNuevo = new Tipo1(this.app, "vivo", 0, "F", 15);
													iter.add(orgNuevo);
													new Thread(orgNuevo).start();					
													this.numOrganismosT1F++;
												}
												
											}
										}
									}
									
									
								}
								
								
							}
							
						}
						
						if(ciclos >= 150) {
							corre = false;
						}
						
					}catch(InterruptedException e) {
						e.printStackTrace();
					}catch(Exception e) {
						e.printStackTrace();
					}
					
				}
				
			}).start();
			
		}
		
	}

	
	public boolean validar(Organismo org1, Organismo org2) {
		
		if(org1 instanceof Tipo1 && org2 instanceof Tipo1) {
			
			//validamos si son del mismo sexo, si no lo son
			//nacera otro elemento tipo 1
			if(!org1.getSexo().equals(org2.getSexo())) {				
				return false;				
			}
		}
		
		return true;
		
	}
	
	public void pintar(){
		this.app.background(255);
		
		for(Organismo organismo : organismos) {
			organismo.pintar();
		}
		this.app.fill(0);
		this.app.text("Ciclos de vida: "+ciclos,50,50);
		this.app.text("Num Org T1 Masculinos: "+numOrganismosT1M,170,50);
		this.app.text("Num Org T1 Femeninos: "+numOrganismosT1F,330,50);
		this.app.text("Num Org T2 Masculinos: "+numOrganismosT2M,170,70);
		this.app.text("Num Org T2 Femeninos: "+numOrganismosT2F,330,70);
		this.app.text("Num Org T3 Masculinos: "+numOrganismosT3M,170,90);
		this.app.text("Num Org T3 Femeninos: "+numOrganismosT3F,330,90);
		
	}
	
}
