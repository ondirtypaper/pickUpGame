package membership;

public class Member {
    private String id;
    private String password;
    private String email;
    private String name;
    private int age;
    private int points;
    private String grade;

    public Member(String id, String password, String email, String name, int age) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.name = name;
        this.age = age;
        this.points = 0;
        this.grade = "일반";
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getPoints() {
        return points;
    }

    public String getGrade() {
        return grade;
    }

    public void setPoints(int points) {
        this.points = points;
        updateGrade();
    }

    private void updateGrade() {
        if (points >= 1000) {
            grade = "플래티넘";
        } else if (points >= 500) {
            grade = "골드";
        } else if (points >= 100) {
            grade = "실버";
        } else {
            grade = "일반";
        }
    }

    @Override
    public String toString() {
        return "아이디: " + id + ", 비밀번호: " + password + ", 이메일: " + email + ", 이름: " + name + ", 나이: " + age + ", 등급: " + grade + ", 포인트: " + points;
    }
}