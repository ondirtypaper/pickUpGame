package membership;

public class Member {
    private String name;
    private int age;
    private int points;
    private String grade;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
        this.points = 0; // 초기 포인트는 0으로 설정
        this.grade = "브론즈"; // 초기 등급은 Bronze으로 설정
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

    public void setPoints(int points) {
        this.points = points;
        updateGrade(); // 포인트 설정 후 등급 업데이트
    }

    public String getGrade() {
        return grade;
    }

    private void updateGrade() {
        if (points >= 5000) {
            grade = "플래티넘";
        } else if (points >= 1000) {
            grade = "골드";
        } else if (points >= 500) {
            grade = "실버";
        } else {
            grade = "브론즈";
        }
    }
}
