package com.tenacity.pysix.domain.authentication;

import com.tenacity.pysix.domain.license.LicenseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tenacity.pysix.domain.authentication.PysixUser;
import com.tenacity.pysix.domain.license.LicenseStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created with IntelliJ IDEA.
 * User: guilherme
 * Date: 8/2/13
 * Time: 5:28 PM
 */
public class PysixUserTest{

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void constructorTest() {
        String name = "john smith";
        String username = "john";
        String password = "smith";
        PysixUser objPysixUser;
        objPysixUser = new PysixUser(name, username, password);
        assertThat("Unexpected Name", name,equalTo(objPysixUser.getName()));
        assertThat("Unexpected Username", username,equalTo(objPysixUser.getUsername()));
        assertThat("Unexpected Password", password,equalTo(objPysixUser.getPassword()));
        assertThat("Parameter value not initialized as expected!!", objPysixUser.isAccountNonExpired(), equalTo(true));
        assertThat("Parameter value not initialized as expected!!", objPysixUser.isAccountNonLocked(), equalTo(true));
        assertThat("Parameter value not initialized as expected!!", objPysixUser.isCredentialsNonExpired(), equalTo(true));
        assertThat("Parameter value not initialized as expected!!", objPysixUser.isEnabled(), equalTo(true));
        assertThat("Parameter value not initialized as expected!!", objPysixUser.getRoles().size(), equalTo(0));
        assertThat("Parameter value not initialized as expected!!", objPysixUser.getLicenseStatus() == LicenseStatus.LICENSED);
    }

}