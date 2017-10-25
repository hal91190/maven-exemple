package fr.uvsq.poo.compte;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class AccountTest {
  private BigDecimal amount100;
  private BigDecimal amount200;
  private BigDecimal invalidAmount;
  private Account account100;

  @Before
  public void setup() {
    amount100 = new BigDecimal("100");
    amount200 = new BigDecimal("200");
    invalidAmount = new BigDecimal("-100");
    account100 = new Account(amount100);
  }

  @Test
  public void anAccountCreatedWithAnAmountShouldHaveABalanceEqualsToThisAmount() {
    assertThat(account100.getBalance(), is(equalTo(amount100)));
  }

  @Test(expected = IllegalArgumentException.class)
  public void aCreationWithANegativeAmountShouldFail() {
    Account account = new Account(invalidAmount);
  }

  @Test
  public void anAccountCreditedWithAnAmountShouldHaveABalanceIncreasedByThisAmount() {
    account100.credit(amount100);
    assertThat(account100.getBalance(), is(equalTo(amount200)));
  }

  @Test(expected = IllegalArgumentException.class)
  public void aCreditWithANegativeAmountShouldFail() {
    account100.credit(invalidAmount);
  }
}
