public class colorCakeDecorator extends cakeCustomizer{
    private String color;
    public colorCakeDecorator(customProduct customizedCake, String color){
        super(customizedCake);
        this.color = color;
    }

    @java.lang.Override
    public void make() {
        super.make();
        setColorFrosting(customizedCake, color);
    }
    private void setColorFrosting(customProduct customizedCake, String color){
        System.out.println("Frosting Color: "+ color);

    }
}
