import java.util.Date;

public abstract class Producte implements Cloneable {
    protected String titol;
    protected Date any_de_publicacio;
    protected String genere;
    protected boolean disponibilitat;

    public Producte(String titol, Date any_de_publicacio, String genere, boolean disponibilitat) {
        this.titol = titol;
        this.any_de_publicacio = any_de_publicacio;
        this.genere = genere;
        this.disponibilitat = disponibilitat;
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            //return new Treballador("0","0");
        }
    }


    @Override
    public String toString() {
        return "Producte{" +
                "titol='" + titol + '\'' +
                ", any_de_publicacio=" + any_de_publicacio +
                ", genere='" + genere + '\'' +
                ", disponibilitat=" + disponibilitat +
                '}';
    }
}
