package fr.uvsq.poo.compte;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
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
    assertThat(account100.getBalance(), is(equalTo(amount100)));
  }

  @Test
  public void aCreationWithANegativeAmountShouldFail() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> new Account(invalidAmount));
    assertEquals("Montant invalide", exception.getMessage());
  }

  @Test
  public void anAccountCreditedWithAnAmountShouldHaveABalanceIncreasedByThisAmount() {
    account100.credit(amount100);
    assertThat(account100.getBalance(), is(equalTo(amount200)));
  }

  @Test
  public void aCreditWithANegativeAmountShouldFail() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> account100.credit(invalidAmount));
    assertEquals("Montant invalide", exception.getMessage());
  }

  @Test
  public void anAccountDebitedWithAnAmountShouldHaveABalanceDecreasedByThisAmount() {
    account200.debit(amount100);
    assertThat(account200.getBalance(), is(equalTo(amount100)));
  }

  @Test
  public void aDebitWithANegativeAmountShouldFail() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> account100.debit(invalidAmount));
    assertEquals("Montant invalide", exception.getMessage());
  }

  @Test
  public void aDebitWithAnAmountHigherThanTheBalanceShouldFail() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> account100.debit(amount200));
    assertEquals("Montant supérieur au solde", exception.getMessage());
  }

  @Test
  public void aTransfertShouldDebitAnAccountAndCreditAnotherOne() {
    account200.transfer(amount100, account100);
    assertThat(account200.getBalance(), is(equalTo(amount100)));
    assertThat(account100.getBalance(), is(equalTo(amount200)));
  }

  @Test
  public void aTransfertWithANegativeAmountShouldFail() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> account100.transfer(invalidAmount, account200));
    assertEquals("Montant invalide", exception.getMessage());
  }

  @Test
  public void aTransfertWithAnAmountHigherThanTheBalanceShouldFail() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> account100.transfer(amount200, account200));
    assertEquals("Montant supérieur au solde", exception.getMessage());
  }

  @Test
  public void aTransfertFromAnAccountToHimselfShouldFail() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> account100.transfer(amount100, account100));
    assertEquals("Virement d'un compte sur lui-même", exception.getMessage());
  }
}
