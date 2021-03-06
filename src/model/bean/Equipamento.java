/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Master
 */
public class Equipamento {
    
    private int idequip;
    private String nome;
    private String fabricante;
    private String modelo;
    private String dt_fabric;
    private String dt_instal;
    private String histor_inicial;
    private String gap_manut;
    private String dt_ultimanut;
    private int atendimentos;
    private String dt_cadastro;
    private String foto;
    private Cliente cliente;
    private Contrato contrato;

    public Equipamento() {
    }

    public Equipamento(int idequip, String nome, String fabricante, String modelo, String dt_fabric, String dt_instal, String histor_inicial, String gap_manut, String dt_ultimanut, int atendimentos, String dt_inic_contrato, String foto, Cliente cliente, Contrato contrato) {
        this.idequip = idequip;
        this.nome = nome;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.dt_fabric = dt_fabric;
        this.dt_instal = dt_instal;
        this.histor_inicial = histor_inicial;
        this.gap_manut = gap_manut;
        this.dt_ultimanut = dt_ultimanut;
        this.atendimentos = atendimentos;
        this.dt_cadastro = dt_cadastro;
        this.foto = foto;
        this.cliente = cliente;
        this.contrato = contrato;
    }



    public int getIdequip() {
        return idequip;
    }

    public void setIdequip(int idequip) {
        this.idequip = idequip;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDt_fabric() {
        return dt_fabric;
    }

    public void setDt_fabric(String dt_fabric) {
        this.dt_fabric = dt_fabric;
    }

    public String getDt_instal() {
        return dt_instal;
    }

    public void setDt_instal(String dt_instal) {
        this.dt_instal = dt_instal;
    }

    public String getHistor_inicial() {
        return histor_inicial;
    }

    public void setHistor_inicial(String histor_inicial) {
        this.histor_inicial = histor_inicial;
    }

    public String getGap_manut() {
        return gap_manut;
    }

    public void setGap_manut(String gap_manut) {
        this.gap_manut = gap_manut;
    }

    public String getDt_ultimanut() {
        return dt_ultimanut;
    }

    public void setDt_ultimanut(String dt_ultimanut) {
        this.dt_ultimanut = dt_ultimanut;
    }


    public int getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(int atendimentos) {
        this.atendimentos = atendimentos;
    }

    public String getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(String dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    @Override
    public String toString() {
        return getNome(); //To change body of generated methods, choose Tools | Templates.
    }

   
}
