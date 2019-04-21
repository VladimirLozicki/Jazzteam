public class CandyFactory {
    public Candy getTypeCandy(TypeCandy type){
        Candy toReturn = null;
        switch (type) {
            case CARAMEL:
                toReturn = new CaramelCandy();
                break;
            case CHOCOLATE:
                toReturn = new ChocolateCandy();
                break;
            case MINT:
                toReturn = new MintCandy();
                break;
            default:
                throw new IllegalArgumentException("Wrong doughnut type:" + type);
        }
        return toReturn;
    }
}

