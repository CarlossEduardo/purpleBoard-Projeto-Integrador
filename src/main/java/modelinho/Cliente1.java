
package modelinho;

/**
 *
 * @author Aluno
 */
public class Cliente1 {
    int idCliente;
    String cpfCliente;
    int codCliente;
    String nomeCliente;

    public Cliente1(int idCliente, String cpfCliente, int codCliente, String nomeCliente) {
        this.idCliente = idCliente;
        this.cpfCliente = cpfCliente;
        this.codCliente = codCliente;
        this.nomeCliente = nomeCliente;
    }
    
    public Cliente1() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    
    
}

