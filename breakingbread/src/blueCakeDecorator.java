public class blueCakeDecorator extends cakeCustomizer{
    public blueCakeDecorator(customProduct customizedCake){
        super(customizedCake);
    }
    @java.lang.Override
    public void make() {
        super.make();
        setBlueFrosting(customizedCake);
    }
    private void setBlueFrosting(customProduct customizedCake){
        System.out.println("Frosting Color: Blue");

    }
}
