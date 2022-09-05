package Top Trip Viagens UML;

import java.util.Set;
import java.util.HashSet;

/**
* @generated
*/
public class passagens {
    
    /**
    * @generated
    */
    private Integer id;
    
    /**
    * @generated
    */
    private Real preco;
    
    /**
    * @generated
    */
    private date data_ida;
    
    /**
    * @generated
    */
    private date data_volta;
    
    /**
    * @generated
    */
    private String origem;
    
    
    /**
    * @generated
    */
    private compra compra;
    
    /**
    * @generated
    */
    private pacote_viagem pacote_viagem;
    
    /**
    * @generated
    */
    private Set<destino> destino;
    
    
    /**
    * @generated
    */
    private Integer getId() {
        return this.id;
    }
    
    /**
    * @generated
    */
    private Integer setId(Integer id) {
        this.id = id;
    }
    
    /**
    * @generated
    */
    private Real getPreco() {
        return this.preco;
    }
    
    /**
    * @generated
    */
    private Real setPreco(Real preco) {
        this.preco = preco;
    }
    
    /**
    * @generated
    */
    private date getData_ida() {
        return this.data_ida;
    }
    
    /**
    * @generated
    */
    private date setData_ida(date data_ida) {
        this.data_ida = data_ida;
    }
    
    /**
    * @generated
    */
    private date getData_volta() {
        return this.data_volta;
    }
    
    /**
    * @generated
    */
    private date setData_volta(date data_volta) {
        this.data_volta = data_volta;
    }
    
    /**
    * @generated
    */
    private String getOrigem() {
        return this.origem;
    }
    
    /**
    * @generated
    */
    private String setOrigem(String origem) {
        this.origem = origem;
    }
    
}
