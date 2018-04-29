public abstract class cakeCustomizer implements customProduct {
    protected customProduct customCake;

    public cakeCustomizer(customProduct customCake) {
        this.customCake = customCake;
    }

    public void make() {

        customCake.make();
    }
}