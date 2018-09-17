package ir.rmv.bss.ibsng.service.subservice;

public interface IbsngUserCreditService {

    Long setCredit(String userId, String credit);

    Long incrementCredit(String userId, String credit);
}
