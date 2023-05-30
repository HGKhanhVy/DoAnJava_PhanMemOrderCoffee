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
public class NguyenLieu_DTO {
    String MANGUYENLIEU, TENNGUYENLIEU, SOLUONG, TONKHO, DVT;

    public String getMANGUYENLIEU() {
        return MANGUYENLIEU;
    }

    public void setMANGUYENLIEU(String MANGUYENLIEU) {
        this.MANGUYENLIEU = MANGUYENLIEU;
    }

    public String getTENNGUYENLIEU() {
        return TENNGUYENLIEU;
    }

    public void setTENNGUYENLIEU(String TENNGUYENLIEU) {
        this.TENNGUYENLIEU = TENNGUYENLIEU;
    }

    public String getSOLUONG() {
        return SOLUONG;
    }

    public void setSOLUONG(String SOLUONG) {
        this.SOLUONG = SOLUONG;
    }

    public String getTONKHO() {
        return TONKHO;
    }

    public void setTONKHO(String TONKHO) {
        this.TONKHO = TONKHO;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public NguyenLieu_DTO(String MANGUYENLIEU, String TENNGUYENLIEU, String SOLUONG, String TONKHO, String DVT) {
        this.MANGUYENLIEU = MANGUYENLIEU;
        this.TENNGUYENLIEU = TENNGUYENLIEU;
        this.SOLUONG = SOLUONG;
        this.TONKHO = TONKHO;
        this.DVT = DVT;
    }
    
}
