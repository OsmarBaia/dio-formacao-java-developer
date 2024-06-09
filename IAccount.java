public interface IAccount {
    void deposit(float value);
    void withdraw(float value);
    void transfer(IAccount destAccount, float value);
    void statement();
}
