package model.massiveastronomicalobject;

public class YellowDwarf implements  Evolution{
    private RedGigant redGigant;

    @Override
    public Object getEvolution(Object object) {
    //    object = new RedGigant();
        return  object;
    }

    @Override
    public void getMessage() {
        System.out.println("YellowDwarf");
    }
}
