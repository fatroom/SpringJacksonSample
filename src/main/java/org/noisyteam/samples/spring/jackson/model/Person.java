package org.noisyteam.samples.spring.jackson.model;

import java.util.Date;

/**
 * Sample model class.
 *
 * @author Roman Romanchuk (fatroom@gmail.com)
 */
public class Person {

    private String name;
    private String nickname;
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
