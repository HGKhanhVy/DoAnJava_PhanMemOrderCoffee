/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author khanh
 */
public class CHUCVU_DTO {
    String maCV, tenCV;

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    public CHUCVU_DTO(String maCV, String tenCV) {
        this.maCV = maCV;
        this.tenCV = tenCV;
    }

    public CHUCVU_DTO() {
    }
    
    
}
