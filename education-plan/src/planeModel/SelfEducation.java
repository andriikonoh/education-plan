package planeModel;

import java.time.LocalDate;

public class SelfEducation implements OrganizationType {

    @Override
    public int getDays(EducationPeriod educationPeriod) {
        int allDays = 0;
        LocalDate date = LocalDate.from(educationPeriod.getStartDate());
        while(date.isBefore(educationPeriod.getEndDate().plusDays(1))) {
            allDays ++;
            date = date.plusDays(1);
        }
        return allDays;
    }

    @Override
    public String apply(EducationPeriod educationPeriod, int amount, int practicePerDay,
                        int theoryPerDay, int discussionPerDay) {
        LocalDate today = LocalDate.now().plusDays(amount);
        if(today.isAfter(educationPeriod.getStartDate().minusDays(1)) &&
                today.isBefore(educationPeriod.getEndDate().plusDays(1)))
            return String.format("SelfEducation practice %d, theory %d\n", practicePerDay,
                    theoryPerDay + discussionPerDay);
        return "";
    }
}