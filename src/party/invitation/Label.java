package party.invitation;

public class Label {
    private String label;

    public Label(String label) {
        this.label = label;
    }

    protected void add(Label label){
        this.label +=label;
    }

    @Override
    public String toString() {
        return label;
    }
}
