package br.com.agenda.Model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Convenio  extends AbstractEntity{

    private String nmConvenio;
    private BigDecimal vlConvenio;

    public Convenio(String nmConvenio, BigDecimal vlConvenio) {
        this.nmConvenio = nmConvenio;
        this.vlConvenio = vlConvenio;
    }

    public Convenio(Long id, LocalDateTime cadastro, LocalDateTime atualizado, LocalDateTime excluido, String nmConvenio, BigDecimal vlConvenio) {
        super(id, cadastro, atualizado, excluido);
        this.nmConvenio = nmConvenio;
        this.vlConvenio = vlConvenio;
    }

    public Convenio() {
    }

    public String getNmConvenio() {
        return nmConvenio;
    }

    public void setNmConvenio(String nmConvenio) {
        this.nmConvenio = nmConvenio;
    }

    public BigDecimal getVlConvenio() {
        return vlConvenio;
    }

    public void setVlConvenio(BigDecimal vlConvenio) {
        this.vlConvenio = vlConvenio;
    }

    @Override
    public String toString() {
        return "Convenio{" +
                "nmConvenio='" + nmConvenio + '\'' +
                ", vlConvenio=" + vlConvenio +
                '}';
    }
}
