//package model.orbita;
//
//import model.planet.Planet;
//import model.planet.Sattelite;
//
//public class Gravity  {
//
//    GeostationaryOrbita geostationaryOrbita;
//    public Gravity(Planet planet, Sattelite sattelite){
//        geostationaryOrbita.planet=planet;
//        geostationaryOrbita.sattelite=sattelite;
//    }
//    public double gravitationOnOrbita(){
//        return geostationaryOrbita.G*geostationaryOrbita.planet.getWeight()
//                *geostationaryOrbita.planet.getWeight()
//                /geostationaryOrbita.heightOrbita()*geostationaryOrbita.heightOrbita();
//    }
//
//    public double gravitationOnSurface(){
//        return geostationaryOrbita.G*geostationaryOrbita.planet.getWeight()
//                *geostationaryOrbita.sattelite.getWeight()/(geostationaryOrbita.heightRise()*geostationaryOrbita.heightRise());
//
//    }
//
//}