package fr.uvsq.poo.compte;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class AccountTest {
  BigDecimal amount100;
  BigDecimal amount200;
  BigDecimal invalidAmount;

  @Before
  public void setup() {
    amount100 = new BigDecimal("100");
    amount200 = new BigDecimal("200");
    invalidAmount = new BigDecimal("-100");
  }

  @Test
  public void anAccountCreatedWithAnAmountShouldHaveABalanceEqualsToThisAmount() {
    Account account = new Account(amount100);
    assertThat(account.getBalance(), is(equalTo(amount100)));
  }

  @Test(expected = IllegalArgumentException.class)
  public void aCreationWithANegativeAmountShouldFail() {
    Account account = new Account(invalidAmount);
  }

  @Test
  public void anAccountCreditedWithAnAmountShouldHaveABalanceIncreasedByThisAmount() {
    Account account = new Account(amount100);
    account.credit(amount100);
    assertThat(account.getBalance(), is(equalTo(amount200)));
  }

  @Test(expected = IllegalArgumentException.class)
  public void aCreditWithANegativeAmountShouldFail() {
    Account account = new Account(amount100);
    account.credit(invalidAmount);
  }
}
