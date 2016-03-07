package party.lib;

public class Label {
    private String label;

    public Label(String label) {
        this.label = label;
    }

    protected void add(Label label){
        this.label +=label;
    }

    protected void addNewLine(){
        this.label +="\n";
    }

    @Override
    public String toString() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Label label1 = (Label) o;

        if (!label.equals(label1.label)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }
}
