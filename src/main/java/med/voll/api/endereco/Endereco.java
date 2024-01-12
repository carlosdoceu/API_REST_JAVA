package med.voll.api.endereco;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.DadosEndereco;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String uf;


    public Endereco(DadosEndereco dadosEndereco) {
        this.logradouro = dadosEndereco.logradouro();
        this.bairro = dadosEndereco.bairro();
        this.numero = dadosEndereco.numero();
        this.complemento = dadosEndereco.complemento();
        this.cep = dadosEndereco.cep();
        this.cidade = dadosEndereco.cidade();
        this.uf = dadosEndereco.uf();

    }
}
