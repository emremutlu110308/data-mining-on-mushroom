package nb;

public class Mushroom {
	private char capShape='\0';  //bell=b,conical=c,convex=x,flat=f, knobbed=k,sunken=s 
	private char capSurface='\0';  //fibrous=f,grooves=g,scaly=y,smooth=s 
	private char capColor='\0';  //brown=n,buff=b,cinnamon=c,gray=g,green=r, pink=p,purple=u,red=e,white=w,yellow=y 
	private char bruises='\0';  //bruises=t,no=f 
    private char odor='\0'; //almond=a,anise=l,creosote=c,fishy=y,foul=f, musty=m,none=n,pungent=p,spicy=s 
	private char gillAttachment='\0';  //attached=a,descending=d,free=f,notched=n 
	private char gillSpacing='\0'; //close=c,crowded=w,distant=d 
	private char gillSize='\0'; //broad=b,narrow=n 
	private char gillColor='\0'; //black=k,brown=n,buff=b,chocolate=h,gray=g, green=r,orange=o,pink=p,purple=u,red=e, white=w,yellow=y 
	private char stalkShape='\0'; //enlarging=e,tapering=t 
	private char stalkRoot='\0'; //bulbous=b,club=c,cup=u,equal=e, rhizomorphs=z,rooted=r,missing=? 
	private char stalkSurfaceAboveRing='\0'; // fibrous=f,scaly=y,silky=k,smooth=s 
	private char stalkSurfaceBelowRing='\0'; //fibrous=f,scaly=y,silky=k,smooth=s 
	private char stalkColorAboveRing='\0'; //brown=n,buff=b,cinnamon=c,gray=g,orange=o, pink=p,red=e,white=w,yellow=y 
	private char stalkColorBelowRing='\0'; //brown=n,buff=b,cinnamon=c,gray=g,orange=o, pink=p,red=e,white=w,yellow=y 
	private char veilType='\0'; // partial=p,universal=u 
	private char veilColor='\0'; // brown=n,orange=o,white=w,yellow=y 
	private char ringNumber='\0'; // none=n,one=o,two=t 
	private char ringType='\0'; //cobwebby=c,evanescent=e,flaring=f,large=l, none=n,pendant=p,sheathing=s,zone=z 
	private char sporePrintColor='\0'; // black=k,brown=n,buff=b,chocolate=h,green=r, orange=o,purple=u,white=w,yellow=y 
	private char population='\0'; //abundant=a,clustered=c,numerous=n, scattered=s,several=v,solitary=y 
	private char habitat='\0'; //grasses=g,leaves=l,meadows=m,paths=p, urban=u,waste=w,woods=d
    private char classDistribution = '\0';
	
    public Mushroom(){}

    
    
    public Mushroom(char capShape, char capSurface, char capColor,
    		char bruises, char odor,  char gillAttachment, char gillSpacing, 
    		char gillSize, char gillColor, char stalkShape, char stalkRoot,
    		char stalkSurfaceAboveRing, char stalkSurfaceBelowRing, char stalkColorAboveRing,
    		char stalkColorBelowRing, char veilType, char veilColor, char ringNumber, 
    		char ringType, char sporePrintColor, char population, char habitat, 
    		char classDistribution){
    	
    	this.capShape = capShape;
    	this.capSurface = capSurface;
    	this.capColor = capColor;
    	this.bruises = bruises;
    	this.odor = odor;
    	this.gillAttachment = gillAttachment;
    	this.gillSpacing = gillSpacing;
    	this.gillSize = gillSize;
    	this.gillColor = gillColor;
    	this.stalkShape = stalkShape;
    	this.stalkRoot = stalkRoot;
    	this.stalkSurfaceAboveRing = stalkSurfaceAboveRing;
    	this.stalkSurfaceBelowRing = stalkSurfaceBelowRing;
    	this.stalkColorAboveRing = stalkColorAboveRing;
    	this.stalkColorBelowRing = stalkColorBelowRing;
    	this.veilColor = veilColor;
    	this.veilType = veilType;
    	this.ringNumber = ringNumber;
    	this.ringType = ringType;
    	this.sporePrintColor = sporePrintColor;
    	this.population = population;
    	this.habitat = habitat;
    	this.classDistribution = classDistribution;
    }
    
    public char getCapShape(){return this.capShape;} 
    public char getCapSurface(){return this.capSurface;}
    public char getCapColor(){return this.capColor;}
    public char getBruises(){return this.bruises;}
    public char getOdor(){return this.odor;}
	public char getGillAttachment(){return this.gillAttachment;}
	public char getGillSpacing(){return this.gillSpacing;}
	public char getGillSize(){return this.gillSize;}
	public char getGillColor(){return this.gillColor;}
	public char getStalkShape(){return this.stalkShape;}
	public char getStalkRoot(){return this.stalkRoot;}
	public char getStalkSurfaceAboveRing(){return this.stalkSurfaceAboveRing;}
	public char getStalkSurfaceBelowRing(){return this.stalkSurfaceBelowRing;}
    public char getStalkColorAboveRing(){return this.stalkColorAboveRing;}
	public char getstalkColorBelowRing(){return this.stalkColorBelowRing;}
	public char getVeilColor(){return this.veilColor;}
	public char getVeilType(){return this.veilType;}
	public char getRingNumber(){return this.ringNumber;}
	public char getRingType(){return this.ringType;}
	public char getSporePrintColor(){ return this.sporePrintColor;}
	public char getPopulation(){return this.population;}
	public char getHabitat(){return this.habitat;}
	public char getClassDistribution(){return this.classDistribution;}
	
	public void setCapShape(char capShape ){this.capShape=capShape;}
    public void setCapSurface(char capSurface){this.capSurface=capSurface;}
    public void setCapColor(char capColor){this.capColor=capColor;}
    public void setBruises(char bruises){ this.bruises=bruises;}
    public void setOdor(char odor){this.odor=odor;}
	public void setGillAttachment(char gillAttachment){this.gillAttachment=gillAttachment;}
	public void setGillSpacing(char gillSpacing){this.gillSpacing=gillSpacing;}
	public void setGillSize(char gillSize){this.gillSize=gillSize;}
	public void setGillColor(char gillColor){this.gillColor=gillColor;}
	public void setStalkShape(char stalkShape){this.stalkShape=stalkShape;}
	public void setStalkRoot(char stalkRoot){this.stalkRoot=stalkRoot;}
	public void setStalkSurfaceAboveRing(char stalkSurfaceAboveRing){this.stalkSurfaceAboveRing=stalkSurfaceAboveRing;}
	public void setStalkSurfaceBelowRing(char stalkSurfaceBelowRing){this.stalkSurfaceBelowRing=stalkSurfaceBelowRing;}
    public void setStalkColorAboveRing(char stalkColorAboveRing){this.stalkColorAboveRing=stalkColorAboveRing;}
	public void setstalkColorBelowRing(char stalkColorBelowRing){this.stalkColorBelowRing=stalkColorBelowRing;}
	public void setVeilColor(char veilColor){this.veilColor=veilColor;}
	public void setVeilType(char veilType){this.veilType=veilType;}
	public void setRingNumber(char ringNumber){this.ringNumber=ringNumber;}
	public void setRingType(char ringType){this.ringType=ringType;}
	public void setSporePrintColor(char sporePrintColor){this.sporePrintColor=sporePrintColor;}
	public void setPopulation(char population){this.population=population;}
	public void setHabitat(char habitat){this.habitat=habitat;}
	public void setClassDistribution(char classDistribution){this.classDistribution=classDistribution;}
	
	public char getAttributeByAttributeName(String attributeName){
         if  (attributeName.equals("cap-shape")){return this.capShape;}
         else if (attributeName.equals("cap-surface")){return this.capSurface;}
         else if (attributeName.equals("cap-color")){return this.capColor;}
         else if (attributeName.equals("bruises")){return this.bruises;}
         else if (attributeName.equals("odor")){return this.odor;}
         else if (attributeName.equals("gill-attachment")){return this.gillAttachment;}
         else if (attributeName.equals("gill-spacing")){return this.gillSpacing;}
         else if (attributeName.equals("gill-size")){return this.gillSize;}
         else if (attributeName.equals("gill-color")){return this.gillColor;}
         else if (attributeName.equals("stalk-shape")){return this.stalkShape;}
         else if (attributeName.equals("stalk-root")){return this.stalkRoot;}
         else if (attributeName.equals("stalk-surface-above-ring")){return this.stalkSurfaceAboveRing;}
         else if (attributeName.equals("stalk-surface-below-ring")){return this.stalkSurfaceBelowRing;}
         else if (attributeName.equals("stalk-color-above-ring")){return this.stalkColorAboveRing;}
         else if (attributeName.equals("stalk-color-below-ring")){return this.stalkColorBelowRing;}
         else if (attributeName.equals("veil-type")){return this.veilType;}
         else if (attributeName.equals("veil-color")){return this.veilColor;}
         else if (attributeName.equals("ring-number")){return this.ringNumber;}
         else if (attributeName.equals("ring-type")){return this.ringType;}
         else if (attributeName.equals("spore-print-color")){return this.sporePrintColor;}
         else if (attributeName.equals("population")){return this.population;}
         else if (attributeName.equals("habitat")){return this.habitat;}
         else{return this.classDistribution;}
	}
	
	public void setAttributeByAttributeName(String attributeName, char value){
        if  (attributeName.equals("cap-shape")){this.capShape = value;}
        else if (attributeName.equals("cap-surface")){this.capSurface = value;}
        else if (attributeName.equals("cap-color")){this.capColor = value;}
        else if (attributeName.equals("bruises")){this.bruises = value;}
        else if (attributeName.equals("odor")){this.odor = value;}
        else if (attributeName.equals("gill-attachment")){this.gillAttachment = value;}
        else if (attributeName.equals("gill-spacing")){this.gillSpacing = value;}
        else if (attributeName.equals("gill-size")){this.gillSize = value;}
        else if (attributeName.equals("gill-color")){this.gillColor = value;}
        else if (attributeName.equals("stalk-shape")){this.stalkShape = value;}
        else if (attributeName.equals("stalk-root")){this.stalkRoot = value;}
        else if (attributeName.equals("stalk-surface-above-ring")){this.stalkSurfaceAboveRing = value;}
        else if (attributeName.equals("stalk-surface-below-ring")){this.stalkSurfaceBelowRing = value;}
        else if (attributeName.equals("stalk-color-above-ring")){this.stalkColorAboveRing = value;}
        else if (attributeName.equals("stalk-color-below-ring")){this.stalkColorBelowRing = value;}
        else if (attributeName.equals("veil-type")){this.veilType = value;}
        else if (attributeName.equals("veil-color")){this.veilColor = value;}
        else if (attributeName.equals("ring-number")){this.ringNumber = value;}
        else if (attributeName.equals("ring-type")){this.ringType = value;}
        else if (attributeName.equals("spore-print-color")){this.sporePrintColor = value;}
        else if (attributeName.equals("population")){this.population = value;}
        else if (attributeName.equals("habitat")){this.habitat = value;}
        else {this.classDistribution = value;}
	}
	
	public String toString(){
		return Character.toString(this.capShape)+Character.toString(this.capSurface)
		 +Character.toString(this.classDistribution);
	}
}
