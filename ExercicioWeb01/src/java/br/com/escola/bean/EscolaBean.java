package br.com.escola.bean;

/**
 * @author Gabriel de Oliveira Ferreira
 */
public class EscolaBean {
    
    private int id;
    private String nome;
    private String matricula;
    private float nota01;
    private float nota02;
    private float nota03;
    private int frequencia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public float getNota01() {
        return nota01;
    }

    public void setNota01(float nota01) {
        this.nota01 = nota01;
    }

    public float getNota02() {
        return nota02;
    }

    public void setNota02(float nota02) {
        this.nota02 = nota02;
    }

    public float getNota03() {
        return nota03;
    }

    public void setNota03(float nota03) {
        this.nota03 = nota03;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }
}
