package fr.uvsq.poo.compte;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

/**
 * La classe <code>Account</code> représente un compte bancaire.
 *
 * @author Stéphane Lopes
 * @version 2017
 */
class Account {
  private BigDecimal balance;

  /**
   * Crée un compte avec un montant initial.
   *
   * @param initialBalance le montant initial
   * @throws IllegalArgumentException si le montant initial est négatif
   */
  public Account(BigDecimal initialBalance) {
    validateAmount(initialBalance);
    balance = initialBalance;
  }

  /**
   * Retourne le solde du compte.
   * @return le solde du compte
   */
  public BigDecimal getBalance() {
    return balance;
  }

  /**
   * Crédite le compte.
   * @param amount le montant à créditer
   * @throws IllegalArgumentException si le montant à créditer est négatif
   */
  public void credit(BigDecimal amount) {
    validateAmount(amount);
    balance = balance.add(amount);
  }

  private static void validateAmount(BigDecimal amount) {
    if (amount.compareTo(ZERO) < 0) {
      throw new IllegalArgumentException("Montant invalide");
    }
  }

  /**
   * Débite le compte.
   * @param amount le montant à débiter
   * @throws IllegalArgumentException si le montant à débiter est négatif ou s'il est supérieur au solde
   */
  public void debit(BigDecimal amount) {

  }
}
