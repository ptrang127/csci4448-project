public class redCakeDecorator extends cakeCustomizer{
    public redCakeDecorator(customProduct customizedCake){
        super(customizedCake);
    }

    @java.lang.Override
    public void make() {
        super.make();
        setRedFrosting(customizedCake);
    }
    private void setRedFrosting(customProduct customizedCake){
        System.out.println("Frosting Color: Red");

    }
}
