package edu.cts.academy.vi.domain.dao;

import edu.cts.academy.vi.ui.form.UserSignUpForm;

public interface UserSignUpDAO {
public String saveSignUp(UserSignUpForm usBean);
public int clogin(UserSignUpForm cBean);
}
