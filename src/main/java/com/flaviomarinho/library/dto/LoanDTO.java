package com.flaviomarinho.library.dto;

import java.util.List;

public class LoanDTO {
    private Long user;
    private List<DetailLoanDTO> detailLoanDTOS;

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public List<DetailLoanDTO> getDetailLoanDTOS() {
        return detailLoanDTOS;
    }

    public void setDetailLoanDTOS(List<DetailLoanDTO> detailLoanDTOS) {
        this.detailLoanDTOS = detailLoanDTOS;
    }
}
