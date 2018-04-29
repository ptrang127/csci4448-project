public abstract class cakeCustomizer implements customProduct {
    protected customProduct customizedCake;
    public cakeCustomizer(customProduct customizedCake) {

        this.customizedCake = customizedCake;
    }

    public void make() {

        customizedCake.make();
    }
}