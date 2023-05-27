/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author caoth
 */
public class NhaCungCap_DTO {
    String MANHACUNGCAP,TENNHACUNGCAP,DIACHI,SDT;

    public NhaCungCap_DTO(String MANHACUNGCAP, String TENNHACUNGCAP, String DIACHI, String SDT) {
        this.MANHACUNGCAP = MANHACUNGCAP;
        this.TENNHACUNGCAP = TENNHACUNGCAP;
        this.DIACHI = DIACHI;
        this.SDT = SDT;
    }

    public String getMANHACUNGCAP() {
        return MANHACUNGCAP;
    }

    public void setMANHACUNGCAP(String MANHACUNGCAP) {
        this.MANHACUNGCAP = MANHACUNGCAP;
    }

    public String getTENNHACUNGCAP() {
        return TENNHACUNGCAP;
    }

    public void setTENNHACUNGCAP(String TENNHACUNGCAP) {
        this.TENNHACUNGCAP = TENNHACUNGCAP;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
}
