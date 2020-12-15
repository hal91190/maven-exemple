package fr.uvsq.poo.compte;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {
  private BigDecimal amount100;
  private BigDecimal amount200;
  private BigDecimal invalidAmount;
  private Account account100;
  private Account account200;

  @BeforeEach
  public void setup() {
    amount100 = new BigDecimal("100");
    amount200 = new BigDecimal("200");
    invalidAmount = new BigDecimal("-100");
    account100 = new Account(amount100);
    account200 = new Account(amount200);
  }

  @Test
  public void anAccountCreatedWithAnAmountShouldHaveABalanceEqualsToThisAmount() {
    assertEquals(amount100, account100.getBalance());
  }

  @Test
  public void aCreationWithANegativeAmountShouldFail() {
    assertThrows(IllegalArgumentException.class, () -> new Account(invalidAmount));
  }

  @Test
  public void anAccountCreditedWithAnAmountShouldHaveABalanceIncreasedByThisAmount() {
    account100.credit(amount100);
    assertEquals(amount200, account100.getBalance());
  }

  @Test
  public void aCreditWithANegativeAmountShouldFail() {
    assertThrows(IllegalArgumentException.class, () -> account100.credit(invalidAmount));
  }

  @Test
  public void anAccountDebitedWithAnAmountShouldHaveABalanceDecreasedByThisAmount() {
    account200.debit(amount100);
    assertEquals(amount100, account200.getBalance());
  }

  @Test
  public void aDebitWithANegativeAmountShouldFail() {
    assertThrows(IllegalArgumentException.class, () -> account100.debit(invalidAmount));
  }

  @Test
  public void aDebitWithAnAmountHigherThanTheBalanceShouldFail() {
    assertThrows(IllegalArgumentException.class, () -> account100.debit(amount200));
  }

  @Test
  public void aTransfertShouldDebitAnAccountAndCreditAnotherOne() {
    account200.transfer(amount100, account100);
    assertEquals(amount100, account200.getBalance());
    assertEquals(amount200, account100.getBalance());
  }

  @Test
  public void aTransfertWithANegativeAmountShouldFail() {
    assertThrows(IllegalArgumentException.class, () -> account100.transfer(invalidAmount, account200));
  }

  @Test
  public void aTransfertWithAnAmountHigherThanTheBalanceShouldFail() {
    assertThrows(IllegalArgumentException.class, () -> account100.transfer(amount200, account100));
  }

  @Test
  public void aTransfertFromAnAccountToHimselfShouldFail() {
    assertThrows(IllegalArgumentException.class, () -> account100.transfer(amount100, account100));
  }

}
