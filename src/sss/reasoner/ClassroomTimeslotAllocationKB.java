package sss.reasoner;

import sss.scheduler.objects.Lesson;
import sss.scheduler.objects.Subject;
import sss.scheduler.objects.Schedule;
import sss.scheduler.objects.Teacher;
import sss.scheduler.objects.LessonHour;
import sss.scheduler.objects.Classroom;
import sss.scheduler.properties.Availability;
import sss.scheduler.objects.ClassInSchool;

/**
 * Rule base used to allocate a lesson object to a classroom and time slot.
 */
  class Jeops_RuleBase_ClassroomTimeslotAllocationKB extends jeops.AbstractRuleBase {

/* 
 * Allocation rule, class doesn't have this subject at the same day
 * and teacher has already been in the classroom that day 
 */
  
    /**
     * Identifiers of rule allocationRule1
     */
    private String[] identifiers_allocationRule1 = {
        "schedule",
        "lessonToAllocate",
        "classroom",
        "hour"
    };

    /**
     * Returns the identifiers declared in rule allocationRule1
     *
     * @return the identifiers declared in rule allocationRule1
     */
    private String[] getDeclaredIdentifiers_allocationRule1() {
         return identifiers_allocationRule1;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule allocationRule1.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_allocationRule1(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.Lesson";
            case 2: return "sss.scheduler.objects.Classroom";
            case 3: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule allocationRule1.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_allocationRule1(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.Lesson.class;
            case 2: return sss.scheduler.objects.Classroom.class;
            case 3: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule allocationRule1.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_allocationRule1(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 2: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
            case 3: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule allocationRule1.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_allocationRule1(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Schedule_1;
            case 1: return sss_scheduler_objects_Lesson_1;
            case 2: return sss_scheduler_objects_Classroom_1;
            case 3: return sss_scheduler_objects_LessonHour_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule allocationRule1
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_allocationRule1() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Classroom_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule allocationRule1
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_allocationRule1(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[1];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[2];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[3];
    }

    /**
     * Condition 0 of rule allocationRule1.<p>
     * The original expression was:<br>
     * <code>schedule.containsLessonInSchedulingSet(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule1_cond_0() {
        return (sss_scheduler_objects_Schedule_1.containsLessonInSchedulingSet(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 1 of rule allocationRule1.<p>
     * The original expression was:<br>
     * <code>!lessonToAllocate.isAllocatedToTimeslot()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule1_cond_1() {
        return (!sss_scheduler_objects_Lesson_1.isAllocatedToTimeslot());
    }

    /**
     * Condition 2 of rule allocationRule1.<p>
     * The original expression was:<br>
     * <code>classroom.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule1_cond_2() {
        return (sss_scheduler_objects_Classroom_1.isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 3 of rule allocationRule1.<p>
     * The original expression was:<br>
     * <code>schedule.teacherAlreadyScheduledInClassroomOnWeekday(teacher, classroom, hour)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule1_cond_3() {
        return (sss_scheduler_objects_Schedule_1.teacherAlreadyScheduledInClassroomOnWeekday((sss_scheduler_objects_Lesson_1.getTeacher()), sss_scheduler_objects_Classroom_1, sss_scheduler_objects_LessonHour_1));
    }

    /**
     * Condition 4 of rule allocationRule1.<p>
     * The original expression was:<br>
     * <code>!schedule.subjectAlreadyAllocatedToClassOnWeekday(subject, hour, classToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule1_cond_4() {
        return (!sss_scheduler_objects_Schedule_1.subjectAlreadyAllocatedToClassOnWeekday((sss_scheduler_objects_Lesson_1.getSubject()), sss_scheduler_objects_LessonHour_1, (sss_scheduler_objects_Lesson_1.getClassInSchool())));
    }

    /**
     * Condition 5 of rule allocationRule1.<p>
     * The original expression was:<br>
     * <code>classToAllocate.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule1_cond_5() {
        return ((sss_scheduler_objects_Lesson_1.getClassInSchool()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 6 of rule allocationRule1.<p>
     * The original expression was:<br>
     * <code>teacher.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule1_cond_6() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 7 of rule allocationRule1.<p>
     * The original expression was:<br>
     * <code>teacher.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule1_cond_7() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 8 of rule allocationRule1.<p>
     * The original expression was:<br>
     * <code>!teacher.isScheduled(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule1_cond_8() {
        return (!(sss_scheduler_objects_Lesson_1.getTeacher()).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Checks whether some conditions of rule allocationRule1 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule1_cond(int index) {
        switch (index) {
            case 0: return allocationRule1_cond_0();
            case 1: return allocationRule1_cond_1();
            case 2: return allocationRule1_cond_2();
            case 3: return allocationRule1_cond_3();
            case 4: return allocationRule1_cond_4();
            case 5: return allocationRule1_cond_5();
            case 6: return allocationRule1_cond_6();
            case 7: return allocationRule1_cond_7();
            case 8: return allocationRule1_cond_8();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule allocationRule1 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_allocationRule1(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!allocationRule1_cond_1()) return false;
                if (!allocationRule1_cond_6()) return false;
                return true;
            case 2:
                return true;
            case 3:
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_allocationRule1(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!allocationRule1_cond_0()) return false;
                return true;
            case 2:
                return true;
            case 3:
                if (!allocationRule1_cond_2()) return false;
                if (!allocationRule1_cond_3()) return false;
                if (!allocationRule1_cond_4()) return false;
                if (!allocationRule1_cond_5()) return false;
                if (!allocationRule1_cond_7()) return false;
                if (!allocationRule1_cond_8()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule allocationRule1
     */
    private void allocationRule1() {
      System.out.println("allocationRule1 fired");
  	  sss_scheduler_objects_Schedule_1.scheduleLesson(sss_scheduler_objects_Lesson_1, sss_scheduler_objects_Classroom_1, (sss_scheduler_objects_Lesson_1.getClassInSchool()), (sss_scheduler_objects_Lesson_1.getTeacher()), sss_scheduler_objects_LessonHour_1);
  	  modified(sss_scheduler_objects_Schedule_1);
  	  modified(sss_scheduler_objects_Classroom_1);
  	  modified((sss_scheduler_objects_Lesson_1.getClassInSchool()));
  	  modified((sss_scheduler_objects_Lesson_1.getTeacher()));
  	  retract(sss_scheduler_objects_Lesson_1);
      }


  
/* 
 * Allocation rule, class doesn't have this subject at the same day
 * and classroom is suited specially for this lesson
 */
  
    /**
     * Identifiers of rule allocationRule2
     */
    private String[] identifiers_allocationRule2 = {
        "schedule",
        "lessonToAllocate",
        "classroom",
        "hour"
    };

    /**
     * Returns the identifiers declared in rule allocationRule2
     *
     * @return the identifiers declared in rule allocationRule2
     */
    private String[] getDeclaredIdentifiers_allocationRule2() {
         return identifiers_allocationRule2;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule allocationRule2.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_allocationRule2(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.Lesson";
            case 2: return "sss.scheduler.objects.Classroom";
            case 3: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule allocationRule2.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_allocationRule2(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.Lesson.class;
            case 2: return sss.scheduler.objects.Classroom.class;
            case 3: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule allocationRule2.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_allocationRule2(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 2: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
            case 3: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule allocationRule2.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_allocationRule2(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Schedule_1;
            case 1: return sss_scheduler_objects_Lesson_1;
            case 2: return sss_scheduler_objects_Classroom_1;
            case 3: return sss_scheduler_objects_LessonHour_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule allocationRule2
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_allocationRule2() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Classroom_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule allocationRule2
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_allocationRule2(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[1];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[2];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[3];
    }

    /**
     * Condition 0 of rule allocationRule2.<p>
     * The original expression was:<br>
     * <code>schedule.containsLessonInSchedulingSet(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule2_cond_0() {
        return (sss_scheduler_objects_Schedule_1.containsLessonInSchedulingSet(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 1 of rule allocationRule2.<p>
     * The original expression was:<br>
     * <code>!lessonToAllocate.isAllocatedToTimeslot()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule2_cond_1() {
        return (!sss_scheduler_objects_Lesson_1.isAllocatedToTimeslot());
    }

    /**
     * Condition 2 of rule allocationRule2.<p>
     * The original expression was:<br>
     * <code>teacher.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule2_cond_2() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 3 of rule allocationRule2.<p>
     * The original expression was:<br>
     * <code>!schedule.subjectAlreadyAllocatedToClassOnWeekday(subject, hour, classToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule2_cond_3() {
        return (!sss_scheduler_objects_Schedule_1.subjectAlreadyAllocatedToClassOnWeekday((sss_scheduler_objects_Lesson_1.getSubject()), sss_scheduler_objects_LessonHour_1, (sss_scheduler_objects_Lesson_1.getClassInSchool())));
    }

    /**
     * Condition 4 of rule allocationRule2.<p>
     * The original expression was:<br>
     * <code>classroom.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule2_cond_4() {
        return (sss_scheduler_objects_Classroom_1.isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 5 of rule allocationRule2.<p>
     * The original expression was:<br>
     * <code>classroom.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule2_cond_5() {
        return (sss_scheduler_objects_Classroom_1.isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 6 of rule allocationRule2.<p>
     * The original expression was:<br>
     * <code>classToAllocate.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule2_cond_6() {
        return ((sss_scheduler_objects_Lesson_1.getClassInSchool()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 7 of rule allocationRule2.<p>
     * The original expression was:<br>
     * <code>teacher.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule2_cond_7() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 8 of rule allocationRule2.<p>
     * The original expression was:<br>
     * <code>!teacher.isScheduled(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule2_cond_8() {
        return (!(sss_scheduler_objects_Lesson_1.getTeacher()).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Checks whether some conditions of rule allocationRule2 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule2_cond(int index) {
        switch (index) {
            case 0: return allocationRule2_cond_0();
            case 1: return allocationRule2_cond_1();
            case 2: return allocationRule2_cond_2();
            case 3: return allocationRule2_cond_3();
            case 4: return allocationRule2_cond_4();
            case 5: return allocationRule2_cond_5();
            case 6: return allocationRule2_cond_6();
            case 7: return allocationRule2_cond_7();
            case 8: return allocationRule2_cond_8();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule allocationRule2 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_allocationRule2(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!allocationRule2_cond_1()) return false;
                if (!allocationRule2_cond_2()) return false;
                return true;
            case 2:
                return true;
            case 3:
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_allocationRule2(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!allocationRule2_cond_0()) return false;
                return true;
            case 2:
                if (!allocationRule2_cond_5()) return false;
                return true;
            case 3:
                if (!allocationRule2_cond_3()) return false;
                if (!allocationRule2_cond_4()) return false;
                if (!allocationRule2_cond_6()) return false;
                if (!allocationRule2_cond_7()) return false;
                if (!allocationRule2_cond_8()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule allocationRule2
     */
    private void allocationRule2() {
      System.out.println("allocationRule2 fired");
  	  sss_scheduler_objects_Schedule_1.scheduleLesson(sss_scheduler_objects_Lesson_1, sss_scheduler_objects_Classroom_1, (sss_scheduler_objects_Lesson_1.getClassInSchool()), (sss_scheduler_objects_Lesson_1.getTeacher()), sss_scheduler_objects_LessonHour_1);
  	  modified(sss_scheduler_objects_Schedule_1);
  	  modified(sss_scheduler_objects_Classroom_1);
  	  modified((sss_scheduler_objects_Lesson_1.getClassInSchool()));
  	  modified((sss_scheduler_objects_Lesson_1.getTeacher()));
  	  retract(sss_scheduler_objects_Lesson_1);
      }




/* 
 * Allocation rule, class doesn't have this subject at the same day
 * and put lesson in classroom for general use 
 */
  
    /**
     * Identifiers of rule allocationRule3
     */
    private String[] identifiers_allocationRule3 = {
        "schedule",
        "lessonToAllocate",
        "classroom",
        "hour"
    };

    /**
     * Returns the identifiers declared in rule allocationRule3
     *
     * @return the identifiers declared in rule allocationRule3
     */
    private String[] getDeclaredIdentifiers_allocationRule3() {
         return identifiers_allocationRule3;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule allocationRule3.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_allocationRule3(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.Lesson";
            case 2: return "sss.scheduler.objects.Classroom";
            case 3: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule allocationRule3.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_allocationRule3(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.Lesson.class;
            case 2: return sss.scheduler.objects.Classroom.class;
            case 3: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule allocationRule3.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_allocationRule3(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 2: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
            case 3: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule allocationRule3.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_allocationRule3(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Schedule_1;
            case 1: return sss_scheduler_objects_Lesson_1;
            case 2: return sss_scheduler_objects_Classroom_1;
            case 3: return sss_scheduler_objects_LessonHour_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule allocationRule3
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_allocationRule3() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Classroom_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule allocationRule3
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_allocationRule3(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[1];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[2];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[3];
    }

    /**
     * Condition 0 of rule allocationRule3.<p>
     * The original expression was:<br>
     * <code>schedule.containsLessonInSchedulingSet(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule3_cond_0() {
        return (sss_scheduler_objects_Schedule_1.containsLessonInSchedulingSet(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 1 of rule allocationRule3.<p>
     * The original expression was:<br>
     * <code>!lessonToAllocate.isAllocatedToTimeslot()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule3_cond_1() {
        return (!sss_scheduler_objects_Lesson_1.isAllocatedToTimeslot());
    }

    /**
     * Condition 2 of rule allocationRule3.<p>
     * The original expression was:<br>
     * <code>!classroom.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule3_cond_2() {
        return (!sss_scheduler_objects_Classroom_1.isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 3 of rule allocationRule3.<p>
     * The original expression was:<br>
     * <code>!lessonToAllocate.needsSpecialClassroom()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule3_cond_3() {
        return (!sss_scheduler_objects_Lesson_1.needsSpecialClassroom());
    }

    /**
     * Condition 4 of rule allocationRule3.<p>
     * The original expression was:<br>
     * <code>!schedule.subjectAlreadyAllocatedToClassOnWeekday(subject, hour, classToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule3_cond_4() {
        return (!sss_scheduler_objects_Schedule_1.subjectAlreadyAllocatedToClassOnWeekday((sss_scheduler_objects_Lesson_1.getSubject()), sss_scheduler_objects_LessonHour_1, (sss_scheduler_objects_Lesson_1.getClassInSchool())));
    }

    /**
     * Condition 5 of rule allocationRule3.<p>
     * The original expression was:<br>
     * <code>classroom.isSuitedForGeneralUse()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule3_cond_5() {
        return (sss_scheduler_objects_Classroom_1.isSuitedForGeneralUse());
    }

    /**
     * Condition 6 of rule allocationRule3.<p>
     * The original expression was:<br>
     * <code>classroom.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule3_cond_6() {
        return (sss_scheduler_objects_Classroom_1.isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 7 of rule allocationRule3.<p>
     * The original expression was:<br>
     * <code>classToAllocate.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule3_cond_7() {
        return ((sss_scheduler_objects_Lesson_1.getClassInSchool()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 8 of rule allocationRule3.<p>
     * The original expression was:<br>
     * <code>teacher.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule3_cond_8() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 9 of rule allocationRule3.<p>
     * The original expression was:<br>
     * <code>teacher.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule3_cond_9() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 10 of rule allocationRule3.<p>
     * The original expression was:<br>
     * <code>!teacher.isScheduled(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule3_cond_10() {
        return (!(sss_scheduler_objects_Lesson_1.getTeacher()).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Checks whether some conditions of rule allocationRule3 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule3_cond(int index) {
        switch (index) {
            case 0: return allocationRule3_cond_0();
            case 1: return allocationRule3_cond_1();
            case 2: return allocationRule3_cond_2();
            case 3: return allocationRule3_cond_3();
            case 4: return allocationRule3_cond_4();
            case 5: return allocationRule3_cond_5();
            case 6: return allocationRule3_cond_6();
            case 7: return allocationRule3_cond_7();
            case 8: return allocationRule3_cond_8();
            case 9: return allocationRule3_cond_9();
            case 10: return allocationRule3_cond_10();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule allocationRule3 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_allocationRule3(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!allocationRule3_cond_1()) return false;
                if (!allocationRule3_cond_3()) return false;
                if (!allocationRule3_cond_8()) return false;
                return true;
            case 2:
                if (!allocationRule3_cond_5()) return false;
                return true;
            case 3:
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_allocationRule3(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!allocationRule3_cond_0()) return false;
                return true;
            case 2:
                if (!allocationRule3_cond_2()) return false;
                return true;
            case 3:
                if (!allocationRule3_cond_4()) return false;
                if (!allocationRule3_cond_6()) return false;
                if (!allocationRule3_cond_7()) return false;
                if (!allocationRule3_cond_9()) return false;
                if (!allocationRule3_cond_10()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule allocationRule3
     */
    private void allocationRule3() {
      System.out.println("allocationRule3 fired");
  	  sss_scheduler_objects_Schedule_1.scheduleLesson(sss_scheduler_objects_Lesson_1, sss_scheduler_objects_Classroom_1, (sss_scheduler_objects_Lesson_1.getClassInSchool()), (sss_scheduler_objects_Lesson_1.getTeacher()), sss_scheduler_objects_LessonHour_1);
  	  modified(sss_scheduler_objects_Schedule_1);
  	  modified(sss_scheduler_objects_Classroom_1);
  	  modified((sss_scheduler_objects_Lesson_1.getClassInSchool()));
  	  modified((sss_scheduler_objects_Lesson_1.getTeacher()));
  	  retract(sss_scheduler_objects_Lesson_1);
      }

 
  
/* 
 * Allocation rule, subject without homework on a day where such subjects aren't allocated yet,
 * teacher has already been in the classroom that day 
 */
   
    /**
     * Identifiers of rule allocationRule4
     */
    private String[] identifiers_allocationRule4 = {
        "schedule",
        "lessonToAllocate",
        "classroom",
        "hour"
    };

    /**
     * Returns the identifiers declared in rule allocationRule4
     *
     * @return the identifiers declared in rule allocationRule4
     */
    private String[] getDeclaredIdentifiers_allocationRule4() {
         return identifiers_allocationRule4;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule allocationRule4.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_allocationRule4(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.Lesson";
            case 2: return "sss.scheduler.objects.Classroom";
            case 3: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule allocationRule4.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_allocationRule4(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.Lesson.class;
            case 2: return sss.scheduler.objects.Classroom.class;
            case 3: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule allocationRule4.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_allocationRule4(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 2: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
            case 3: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule allocationRule4.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_allocationRule4(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Schedule_1;
            case 1: return sss_scheduler_objects_Lesson_1;
            case 2: return sss_scheduler_objects_Classroom_1;
            case 3: return sss_scheduler_objects_LessonHour_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule allocationRule4
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_allocationRule4() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Classroom_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule allocationRule4
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_allocationRule4(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[1];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[2];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[3];
    }

    /**
     * Condition 0 of rule allocationRule4.<p>
     * The original expression was:<br>
     * <code>schedule.containsLessonInSchedulingSet(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule4_cond_0() {
        return (sss_scheduler_objects_Schedule_1.containsLessonInSchedulingSet(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 1 of rule allocationRule4.<p>
     * The original expression was:<br>
     * <code>!lessonToAllocate.isAllocatedToTimeslot()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule4_cond_1() {
        return (!sss_scheduler_objects_Lesson_1.isAllocatedToTimeslot());
    }

    /**
     * Condition 2 of rule allocationRule4.<p>
     * The original expression was:<br>
     * <code>!subject.requiresHomework()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule4_cond_2() {
        return (!(sss_scheduler_objects_Lesson_1.getSubject()).requiresHomework());
    }

    /**
     * Condition 3 of rule allocationRule4.<p>
     * The original expression was:<br>
     * <code>schedule.noClassesWithoutHomeworkOnWeekday(classToAllocate, hour)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule4_cond_3() {
        return (sss_scheduler_objects_Schedule_1.noClassesWithoutHomeworkOnWeekday((sss_scheduler_objects_Lesson_1.getClassInSchool()), sss_scheduler_objects_LessonHour_1));
    }

    /**
     * Condition 4 of rule allocationRule4.<p>
     * The original expression was:<br>
     * <code>classroom.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule4_cond_4() {
        return (sss_scheduler_objects_Classroom_1.isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 5 of rule allocationRule4.<p>
     * The original expression was:<br>
     * <code>schedule.teacherAlreadyScheduledInClassroomOnWeekday(teacher, classroom, hour)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule4_cond_5() {
        return (sss_scheduler_objects_Schedule_1.teacherAlreadyScheduledInClassroomOnWeekday((sss_scheduler_objects_Lesson_1.getTeacher()), sss_scheduler_objects_Classroom_1, sss_scheduler_objects_LessonHour_1));
    }

    /**
     * Condition 6 of rule allocationRule4.<p>
     * The original expression was:<br>
     * <code>classToAllocate.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule4_cond_6() {
        return ((sss_scheduler_objects_Lesson_1.getClassInSchool()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 7 of rule allocationRule4.<p>
     * The original expression was:<br>
     * <code>teacher.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule4_cond_7() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 8 of rule allocationRule4.<p>
     * The original expression was:<br>
     * <code>teacher.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule4_cond_8() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 9 of rule allocationRule4.<p>
     * The original expression was:<br>
     * <code>!teacher.isScheduled(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule4_cond_9() {
        return (!(sss_scheduler_objects_Lesson_1.getTeacher()).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Checks whether some conditions of rule allocationRule4 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule4_cond(int index) {
        switch (index) {
            case 0: return allocationRule4_cond_0();
            case 1: return allocationRule4_cond_1();
            case 2: return allocationRule4_cond_2();
            case 3: return allocationRule4_cond_3();
            case 4: return allocationRule4_cond_4();
            case 5: return allocationRule4_cond_5();
            case 6: return allocationRule4_cond_6();
            case 7: return allocationRule4_cond_7();
            case 8: return allocationRule4_cond_8();
            case 9: return allocationRule4_cond_9();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule allocationRule4 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_allocationRule4(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!allocationRule4_cond_1()) return false;
                if (!allocationRule4_cond_2()) return false;
                if (!allocationRule4_cond_7()) return false;
                return true;
            case 2:
                return true;
            case 3:
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_allocationRule4(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!allocationRule4_cond_0()) return false;
                return true;
            case 2:
                return true;
            case 3:
                if (!allocationRule4_cond_3()) return false;
                if (!allocationRule4_cond_4()) return false;
                if (!allocationRule4_cond_5()) return false;
                if (!allocationRule4_cond_6()) return false;
                if (!allocationRule4_cond_8()) return false;
                if (!allocationRule4_cond_9()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule allocationRule4
     */
    private void allocationRule4() {
      System.out.println("allocationRule4 fired");
  	  sss_scheduler_objects_Schedule_1.scheduleLesson(sss_scheduler_objects_Lesson_1, sss_scheduler_objects_Classroom_1, (sss_scheduler_objects_Lesson_1.getClassInSchool()), (sss_scheduler_objects_Lesson_1.getTeacher()), sss_scheduler_objects_LessonHour_1);
  	  modified(sss_scheduler_objects_Schedule_1);
  	  modified(sss_scheduler_objects_Classroom_1);
  	  modified((sss_scheduler_objects_Lesson_1.getClassInSchool()));
  	  modified((sss_scheduler_objects_Lesson_1.getTeacher()));
  	  retract(sss_scheduler_objects_Lesson_1);
      }


  
/* 
 * Allocation rule, subject without homework on a day where such subjects aren't allocated yet,
 * classroom is suited specially for this lesson
 */
   
    /**
     * Identifiers of rule allocationRule5
     */
    private String[] identifiers_allocationRule5 = {
        "schedule",
        "lessonToAllocate",
        "classroom",
        "hour"
    };

    /**
     * Returns the identifiers declared in rule allocationRule5
     *
     * @return the identifiers declared in rule allocationRule5
     */
    private String[] getDeclaredIdentifiers_allocationRule5() {
         return identifiers_allocationRule5;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule allocationRule5.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_allocationRule5(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.Lesson";
            case 2: return "sss.scheduler.objects.Classroom";
            case 3: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule allocationRule5.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_allocationRule5(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.Lesson.class;
            case 2: return sss.scheduler.objects.Classroom.class;
            case 3: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule allocationRule5.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_allocationRule5(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 2: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
            case 3: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule allocationRule5.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_allocationRule5(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Schedule_1;
            case 1: return sss_scheduler_objects_Lesson_1;
            case 2: return sss_scheduler_objects_Classroom_1;
            case 3: return sss_scheduler_objects_LessonHour_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule allocationRule5
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_allocationRule5() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Classroom_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule allocationRule5
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_allocationRule5(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[1];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[2];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[3];
    }

    /**
     * Condition 0 of rule allocationRule5.<p>
     * The original expression was:<br>
     * <code>schedule.containsLessonInSchedulingSet(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule5_cond_0() {
        return (sss_scheduler_objects_Schedule_1.containsLessonInSchedulingSet(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 1 of rule allocationRule5.<p>
     * The original expression was:<br>
     * <code>!lessonToAllocate.isAllocatedToTimeslot()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule5_cond_1() {
        return (!sss_scheduler_objects_Lesson_1.isAllocatedToTimeslot());
    }

    /**
     * Condition 2 of rule allocationRule5.<p>
     * The original expression was:<br>
     * <code>teacher.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule5_cond_2() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 3 of rule allocationRule5.<p>
     * The original expression was:<br>
     * <code>!subject.requiresHomework()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule5_cond_3() {
        return (!(sss_scheduler_objects_Lesson_1.getSubject()).requiresHomework());
    }

    /**
     * Condition 4 of rule allocationRule5.<p>
     * The original expression was:<br>
     * <code>schedule.noClassesWithoutHomeworkOnWeekday(classToAllocate, hour)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule5_cond_4() {
        return (sss_scheduler_objects_Schedule_1.noClassesWithoutHomeworkOnWeekday((sss_scheduler_objects_Lesson_1.getClassInSchool()), sss_scheduler_objects_LessonHour_1));
    }

    /**
     * Condition 5 of rule allocationRule5.<p>
     * The original expression was:<br>
     * <code>classroom.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule5_cond_5() {
        return (sss_scheduler_objects_Classroom_1.isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 6 of rule allocationRule5.<p>
     * The original expression was:<br>
     * <code>classroom.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule5_cond_6() {
        return (sss_scheduler_objects_Classroom_1.isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 7 of rule allocationRule5.<p>
     * The original expression was:<br>
     * <code>classToAllocate.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule5_cond_7() {
        return ((sss_scheduler_objects_Lesson_1.getClassInSchool()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 8 of rule allocationRule5.<p>
     * The original expression was:<br>
     * <code>teacher.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule5_cond_8() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 9 of rule allocationRule5.<p>
     * The original expression was:<br>
     * <code>!teacher.isScheduled(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule5_cond_9() {
        return (!(sss_scheduler_objects_Lesson_1.getTeacher()).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Checks whether some conditions of rule allocationRule5 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule5_cond(int index) {
        switch (index) {
            case 0: return allocationRule5_cond_0();
            case 1: return allocationRule5_cond_1();
            case 2: return allocationRule5_cond_2();
            case 3: return allocationRule5_cond_3();
            case 4: return allocationRule5_cond_4();
            case 5: return allocationRule5_cond_5();
            case 6: return allocationRule5_cond_6();
            case 7: return allocationRule5_cond_7();
            case 8: return allocationRule5_cond_8();
            case 9: return allocationRule5_cond_9();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule allocationRule5 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_allocationRule5(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!allocationRule5_cond_1()) return false;
                if (!allocationRule5_cond_2()) return false;
                if (!allocationRule5_cond_3()) return false;
                return true;
            case 2:
                return true;
            case 3:
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_allocationRule5(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!allocationRule5_cond_0()) return false;
                return true;
            case 2:
                if (!allocationRule5_cond_6()) return false;
                return true;
            case 3:
                if (!allocationRule5_cond_4()) return false;
                if (!allocationRule5_cond_5()) return false;
                if (!allocationRule5_cond_7()) return false;
                if (!allocationRule5_cond_8()) return false;
                if (!allocationRule5_cond_9()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule allocationRule5
     */
    private void allocationRule5() {
      System.out.println("allocationRule5 fired");
  	  sss_scheduler_objects_Schedule_1.scheduleLesson(sss_scheduler_objects_Lesson_1, sss_scheduler_objects_Classroom_1, (sss_scheduler_objects_Lesson_1.getClassInSchool()), (sss_scheduler_objects_Lesson_1.getTeacher()), sss_scheduler_objects_LessonHour_1);
  	  modified(sss_scheduler_objects_Schedule_1);
  	  modified(sss_scheduler_objects_Classroom_1);
  	  modified((sss_scheduler_objects_Lesson_1.getClassInSchool()));
  	  modified((sss_scheduler_objects_Lesson_1.getTeacher()));
  	  retract(sss_scheduler_objects_Lesson_1);
      }


 
/* 
 * Allocation rule, subject without homework on a day where such subjects aren't allocated yet,
 * put lesson in classroom for general use 
 */ 
  
    /**
     * Identifiers of rule allocationRule6
     */
    private String[] identifiers_allocationRule6 = {
        "schedule",
        "lessonToAllocate",
        "classroom",
        "hour"
    };

    /**
     * Returns the identifiers declared in rule allocationRule6
     *
     * @return the identifiers declared in rule allocationRule6
     */
    private String[] getDeclaredIdentifiers_allocationRule6() {
         return identifiers_allocationRule6;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule allocationRule6.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_allocationRule6(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.Lesson";
            case 2: return "sss.scheduler.objects.Classroom";
            case 3: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule allocationRule6.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_allocationRule6(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.Lesson.class;
            case 2: return sss.scheduler.objects.Classroom.class;
            case 3: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule allocationRule6.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_allocationRule6(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 2: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
            case 3: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule allocationRule6.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_allocationRule6(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Schedule_1;
            case 1: return sss_scheduler_objects_Lesson_1;
            case 2: return sss_scheduler_objects_Classroom_1;
            case 3: return sss_scheduler_objects_LessonHour_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule allocationRule6
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_allocationRule6() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Classroom_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule allocationRule6
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_allocationRule6(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[1];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[2];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[3];
    }

    /**
     * Condition 0 of rule allocationRule6.<p>
     * The original expression was:<br>
     * <code>schedule.containsLessonInSchedulingSet(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule6_cond_0() {
        return (sss_scheduler_objects_Schedule_1.containsLessonInSchedulingSet(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 1 of rule allocationRule6.<p>
     * The original expression was:<br>
     * <code>!lessonToAllocate.isAllocatedToTimeslot()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule6_cond_1() {
        return (!sss_scheduler_objects_Lesson_1.isAllocatedToTimeslot());
    }

    /**
     * Condition 2 of rule allocationRule6.<p>
     * The original expression was:<br>
     * <code>!subject.requiresHomework()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule6_cond_2() {
        return (!(sss_scheduler_objects_Lesson_1.getSubject()).requiresHomework());
    }

    /**
     * Condition 3 of rule allocationRule6.<p>
     * The original expression was:<br>
     * <code>schedule.noClassesWithoutHomeworkOnWeekday(classToAllocate, hour)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule6_cond_3() {
        return (sss_scheduler_objects_Schedule_1.noClassesWithoutHomeworkOnWeekday((sss_scheduler_objects_Lesson_1.getClassInSchool()), sss_scheduler_objects_LessonHour_1));
    }

    /**
     * Condition 4 of rule allocationRule6.<p>
     * The original expression was:<br>
     * <code>!classroom.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule6_cond_4() {
        return (!sss_scheduler_objects_Classroom_1.isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 5 of rule allocationRule6.<p>
     * The original expression was:<br>
     * <code>!lessonToAllocate.needsSpecialClassroom()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule6_cond_5() {
        return (!sss_scheduler_objects_Lesson_1.needsSpecialClassroom());
    }

    /**
     * Condition 6 of rule allocationRule6.<p>
     * The original expression was:<br>
     * <code>classroom.isSuitedForGeneralUse()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule6_cond_6() {
        return (sss_scheduler_objects_Classroom_1.isSuitedForGeneralUse());
    }

    /**
     * Condition 7 of rule allocationRule6.<p>
     * The original expression was:<br>
     * <code>classroom.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule6_cond_7() {
        return (sss_scheduler_objects_Classroom_1.isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 8 of rule allocationRule6.<p>
     * The original expression was:<br>
     * <code>classToAllocate.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule6_cond_8() {
        return ((sss_scheduler_objects_Lesson_1.getClassInSchool()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 9 of rule allocationRule6.<p>
     * The original expression was:<br>
     * <code>teacher.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule6_cond_9() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 10 of rule allocationRule6.<p>
     * The original expression was:<br>
     * <code>teacher.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule6_cond_10() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 11 of rule allocationRule6.<p>
     * The original expression was:<br>
     * <code>!teacher.isScheduled(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule6_cond_11() {
        return (!(sss_scheduler_objects_Lesson_1.getTeacher()).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Checks whether some conditions of rule allocationRule6 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule6_cond(int index) {
        switch (index) {
            case 0: return allocationRule6_cond_0();
            case 1: return allocationRule6_cond_1();
            case 2: return allocationRule6_cond_2();
            case 3: return allocationRule6_cond_3();
            case 4: return allocationRule6_cond_4();
            case 5: return allocationRule6_cond_5();
            case 6: return allocationRule6_cond_6();
            case 7: return allocationRule6_cond_7();
            case 8: return allocationRule6_cond_8();
            case 9: return allocationRule6_cond_9();
            case 10: return allocationRule6_cond_10();
            case 11: return allocationRule6_cond_11();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule allocationRule6 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_allocationRule6(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!allocationRule6_cond_1()) return false;
                if (!allocationRule6_cond_2()) return false;
                if (!allocationRule6_cond_5()) return false;
                if (!allocationRule6_cond_9()) return false;
                return true;
            case 2:
                if (!allocationRule6_cond_6()) return false;
                return true;
            case 3:
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_allocationRule6(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!allocationRule6_cond_0()) return false;
                return true;
            case 2:
                if (!allocationRule6_cond_4()) return false;
                return true;
            case 3:
                if (!allocationRule6_cond_3()) return false;
                if (!allocationRule6_cond_7()) return false;
                if (!allocationRule6_cond_8()) return false;
                if (!allocationRule6_cond_10()) return false;
                if (!allocationRule6_cond_11()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule allocationRule6
     */
    private void allocationRule6() {
      System.out.println("allocationRule6 fired");
  	  sss_scheduler_objects_Schedule_1.scheduleLesson(sss_scheduler_objects_Lesson_1, sss_scheduler_objects_Classroom_1, (sss_scheduler_objects_Lesson_1.getClassInSchool()), (sss_scheduler_objects_Lesson_1.getTeacher()), sss_scheduler_objects_LessonHour_1);
  	  modified(sss_scheduler_objects_Schedule_1);
  	  modified(sss_scheduler_objects_Classroom_1);
  	  modified((sss_scheduler_objects_Lesson_1.getClassInSchool()));
  	  modified((sss_scheduler_objects_Lesson_1.getTeacher()));
  	  retract(sss_scheduler_objects_Lesson_1);
      }



/* Allocation rule, teacher has already been in the classroom that day */
  
    /**
     * Identifiers of rule allocationRule7
     */
    private String[] identifiers_allocationRule7 = {
        "schedule",
        "lessonToAllocate",
        "classroom",
        "hour"
    };

    /**
     * Returns the identifiers declared in rule allocationRule7
     *
     * @return the identifiers declared in rule allocationRule7
     */
    private String[] getDeclaredIdentifiers_allocationRule7() {
         return identifiers_allocationRule7;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule allocationRule7.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_allocationRule7(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.Lesson";
            case 2: return "sss.scheduler.objects.Classroom";
            case 3: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule allocationRule7.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_allocationRule7(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.Lesson.class;
            case 2: return sss.scheduler.objects.Classroom.class;
            case 3: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule allocationRule7.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_allocationRule7(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 2: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
            case 3: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule allocationRule7.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_allocationRule7(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Schedule_1;
            case 1: return sss_scheduler_objects_Lesson_1;
            case 2: return sss_scheduler_objects_Classroom_1;
            case 3: return sss_scheduler_objects_LessonHour_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule allocationRule7
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_allocationRule7() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Classroom_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule allocationRule7
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_allocationRule7(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[1];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[2];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[3];
    }

    /**
     * Condition 0 of rule allocationRule7.<p>
     * The original expression was:<br>
     * <code>schedule.containsLessonInSchedulingSet(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule7_cond_0() {
        return (sss_scheduler_objects_Schedule_1.containsLessonInSchedulingSet(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 1 of rule allocationRule7.<p>
     * The original expression was:<br>
     * <code>!lessonToAllocate.isAllocatedToTimeslot()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule7_cond_1() {
        return (!sss_scheduler_objects_Lesson_1.isAllocatedToTimeslot());
    }

    /**
     * Condition 2 of rule allocationRule7.<p>
     * The original expression was:<br>
     * <code>classroom.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule7_cond_2() {
        return (sss_scheduler_objects_Classroom_1.isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 3 of rule allocationRule7.<p>
     * The original expression was:<br>
     * <code>schedule.teacherAlreadyScheduledInClassroomOnWeekday(teacher, classroom, hour)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule7_cond_3() {
        return (sss_scheduler_objects_Schedule_1.teacherAlreadyScheduledInClassroomOnWeekday((sss_scheduler_objects_Lesson_1.getTeacher()), sss_scheduler_objects_Classroom_1, sss_scheduler_objects_LessonHour_1));
    }

    /**
     * Condition 4 of rule allocationRule7.<p>
     * The original expression was:<br>
     * <code>classToAllocate.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule7_cond_4() {
        return ((sss_scheduler_objects_Lesson_1.getClassInSchool()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 5 of rule allocationRule7.<p>
     * The original expression was:<br>
     * <code>teacher.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule7_cond_5() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 6 of rule allocationRule7.<p>
     * The original expression was:<br>
     * <code>teacher.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule7_cond_6() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 7 of rule allocationRule7.<p>
     * The original expression was:<br>
     * <code>!teacher.isScheduled(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule7_cond_7() {
        return (!(sss_scheduler_objects_Lesson_1.getTeacher()).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Checks whether some conditions of rule allocationRule7 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule7_cond(int index) {
        switch (index) {
            case 0: return allocationRule7_cond_0();
            case 1: return allocationRule7_cond_1();
            case 2: return allocationRule7_cond_2();
            case 3: return allocationRule7_cond_3();
            case 4: return allocationRule7_cond_4();
            case 5: return allocationRule7_cond_5();
            case 6: return allocationRule7_cond_6();
            case 7: return allocationRule7_cond_7();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule allocationRule7 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_allocationRule7(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!allocationRule7_cond_1()) return false;
                if (!allocationRule7_cond_5()) return false;
                return true;
            case 2:
                return true;
            case 3:
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_allocationRule7(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!allocationRule7_cond_0()) return false;
                return true;
            case 2:
                return true;
            case 3:
                if (!allocationRule7_cond_2()) return false;
                if (!allocationRule7_cond_3()) return false;
                if (!allocationRule7_cond_4()) return false;
                if (!allocationRule7_cond_6()) return false;
                if (!allocationRule7_cond_7()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule allocationRule7
     */
    private void allocationRule7() {
      System.out.println("allocationRule7 fired");
  	  sss_scheduler_objects_Schedule_1.scheduleLesson(sss_scheduler_objects_Lesson_1, sss_scheduler_objects_Classroom_1, (sss_scheduler_objects_Lesson_1.getClassInSchool()), (sss_scheduler_objects_Lesson_1.getTeacher()), sss_scheduler_objects_LessonHour_1);
  	  modified(sss_scheduler_objects_Schedule_1);
  	  modified(sss_scheduler_objects_Classroom_1);
  	  modified((sss_scheduler_objects_Lesson_1.getClassInSchool()));
  	  modified((sss_scheduler_objects_Lesson_1.getTeacher()));
  	  retract(sss_scheduler_objects_Lesson_1);
      }



/* Allocation rule, classroom is suited specially for this lesson */
  
    /**
     * Identifiers of rule allocationRule8
     */
    private String[] identifiers_allocationRule8 = {
        "schedule",
        "lessonToAllocate",
        "classroom",
        "hour"
    };

    /**
     * Returns the identifiers declared in rule allocationRule8
     *
     * @return the identifiers declared in rule allocationRule8
     */
    private String[] getDeclaredIdentifiers_allocationRule8() {
         return identifiers_allocationRule8;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule allocationRule8.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_allocationRule8(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.Lesson";
            case 2: return "sss.scheduler.objects.Classroom";
            case 3: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule allocationRule8.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_allocationRule8(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.Lesson.class;
            case 2: return sss.scheduler.objects.Classroom.class;
            case 3: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule allocationRule8.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_allocationRule8(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 2: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
            case 3: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule allocationRule8.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_allocationRule8(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Schedule_1;
            case 1: return sss_scheduler_objects_Lesson_1;
            case 2: return sss_scheduler_objects_Classroom_1;
            case 3: return sss_scheduler_objects_LessonHour_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule allocationRule8
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_allocationRule8() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Classroom_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule allocationRule8
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_allocationRule8(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[1];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[2];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[3];
    }

    /**
     * Condition 0 of rule allocationRule8.<p>
     * The original expression was:<br>
     * <code>schedule.containsLessonInSchedulingSet(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule8_cond_0() {
        return (sss_scheduler_objects_Schedule_1.containsLessonInSchedulingSet(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 1 of rule allocationRule8.<p>
     * The original expression was:<br>
     * <code>!lessonToAllocate.isAllocatedToTimeslot()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule8_cond_1() {
        return (!sss_scheduler_objects_Lesson_1.isAllocatedToTimeslot());
    }

    /**
     * Condition 2 of rule allocationRule8.<p>
     * The original expression was:<br>
     * <code>teacher.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule8_cond_2() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 3 of rule allocationRule8.<p>
     * The original expression was:<br>
     * <code>classroom.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule8_cond_3() {
        return (sss_scheduler_objects_Classroom_1.isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 4 of rule allocationRule8.<p>
     * The original expression was:<br>
     * <code>classroom.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule8_cond_4() {
        return (sss_scheduler_objects_Classroom_1.isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 5 of rule allocationRule8.<p>
     * The original expression was:<br>
     * <code>classToAllocate.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule8_cond_5() {
        return ((sss_scheduler_objects_Lesson_1.getClassInSchool()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 6 of rule allocationRule8.<p>
     * The original expression was:<br>
     * <code>teacher.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule8_cond_6() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 7 of rule allocationRule8.<p>
     * The original expression was:<br>
     * <code>!teacher.isScheduled(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule8_cond_7() {
        return (!(sss_scheduler_objects_Lesson_1.getTeacher()).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Checks whether some conditions of rule allocationRule8 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule8_cond(int index) {
        switch (index) {
            case 0: return allocationRule8_cond_0();
            case 1: return allocationRule8_cond_1();
            case 2: return allocationRule8_cond_2();
            case 3: return allocationRule8_cond_3();
            case 4: return allocationRule8_cond_4();
            case 5: return allocationRule8_cond_5();
            case 6: return allocationRule8_cond_6();
            case 7: return allocationRule8_cond_7();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule allocationRule8 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_allocationRule8(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!allocationRule8_cond_1()) return false;
                if (!allocationRule8_cond_2()) return false;
                return true;
            case 2:
                return true;
            case 3:
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_allocationRule8(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!allocationRule8_cond_0()) return false;
                return true;
            case 2:
                if (!allocationRule8_cond_4()) return false;
                return true;
            case 3:
                if (!allocationRule8_cond_3()) return false;
                if (!allocationRule8_cond_5()) return false;
                if (!allocationRule8_cond_6()) return false;
                if (!allocationRule8_cond_7()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule allocationRule8
     */
    private void allocationRule8() {
      System.out.println("allocationRule8 fired");
  	  sss_scheduler_objects_Schedule_1.scheduleLesson(sss_scheduler_objects_Lesson_1, sss_scheduler_objects_Classroom_1, (sss_scheduler_objects_Lesson_1.getClassInSchool()), (sss_scheduler_objects_Lesson_1.getTeacher()), sss_scheduler_objects_LessonHour_1);
  	  modified(sss_scheduler_objects_Schedule_1);
  	  modified(sss_scheduler_objects_Classroom_1);
  	  modified((sss_scheduler_objects_Lesson_1.getClassInSchool()));
  	  modified((sss_scheduler_objects_Lesson_1.getTeacher()));
  	  retract(sss_scheduler_objects_Lesson_1);
      }




/* Allocation rule, put lesson in classroom for general use */
  
    /**
     * Identifiers of rule allocationRule9
     */
    private String[] identifiers_allocationRule9 = {
        "schedule",
        "lessonToAllocate",
        "classroom",
        "hour"
    };

    /**
     * Returns the identifiers declared in rule allocationRule9
     *
     * @return the identifiers declared in rule allocationRule9
     */
    private String[] getDeclaredIdentifiers_allocationRule9() {
         return identifiers_allocationRule9;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule allocationRule9.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_allocationRule9(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.Lesson";
            case 2: return "sss.scheduler.objects.Classroom";
            case 3: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule allocationRule9.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_allocationRule9(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.Lesson.class;
            case 2: return sss.scheduler.objects.Classroom.class;
            case 3: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule allocationRule9.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_allocationRule9(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 2: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
            case 3: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule allocationRule9.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_allocationRule9(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Schedule_1;
            case 1: return sss_scheduler_objects_Lesson_1;
            case 2: return sss_scheduler_objects_Classroom_1;
            case 3: return sss_scheduler_objects_LessonHour_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule allocationRule9
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_allocationRule9() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Classroom_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule allocationRule9
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_allocationRule9(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[1];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[2];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[3];
    }

    /**
     * Condition 0 of rule allocationRule9.<p>
     * The original expression was:<br>
     * <code>schedule.containsLessonInSchedulingSet(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule9_cond_0() {
        return (sss_scheduler_objects_Schedule_1.containsLessonInSchedulingSet(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 1 of rule allocationRule9.<p>
     * The original expression was:<br>
     * <code>!lessonToAllocate.isAllocatedToTimeslot()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule9_cond_1() {
        return (!sss_scheduler_objects_Lesson_1.isAllocatedToTimeslot());
    }

    /**
     * Condition 2 of rule allocationRule9.<p>
     * The original expression was:<br>
     * <code>!classroom.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule9_cond_2() {
        return (!sss_scheduler_objects_Classroom_1.isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 3 of rule allocationRule9.<p>
     * The original expression was:<br>
     * <code>!lessonToAllocate.needsSpecialClassroom()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule9_cond_3() {
        return (!sss_scheduler_objects_Lesson_1.needsSpecialClassroom());
    }

    /**
     * Condition 4 of rule allocationRule9.<p>
     * The original expression was:<br>
     * <code>classroom.isSuitedForGeneralUse()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule9_cond_4() {
        return (sss_scheduler_objects_Classroom_1.isSuitedForGeneralUse());
    }

    /**
     * Condition 5 of rule allocationRule9.<p>
     * The original expression was:<br>
     * <code>classroom.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule9_cond_5() {
        return (sss_scheduler_objects_Classroom_1.isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 6 of rule allocationRule9.<p>
     * The original expression was:<br>
     * <code>classToAllocate.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule9_cond_6() {
        return ((sss_scheduler_objects_Lesson_1.getClassInSchool()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 7 of rule allocationRule9.<p>
     * The original expression was:<br>
     * <code>teacher.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule9_cond_7() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 8 of rule allocationRule9.<p>
     * The original expression was:<br>
     * <code>teacher.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule9_cond_8() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 9 of rule allocationRule9.<p>
     * The original expression was:<br>
     * <code>!teacher.isScheduled(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule9_cond_9() {
        return (!(sss_scheduler_objects_Lesson_1.getTeacher()).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Checks whether some conditions of rule allocationRule9 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule9_cond(int index) {
        switch (index) {
            case 0: return allocationRule9_cond_0();
            case 1: return allocationRule9_cond_1();
            case 2: return allocationRule9_cond_2();
            case 3: return allocationRule9_cond_3();
            case 4: return allocationRule9_cond_4();
            case 5: return allocationRule9_cond_5();
            case 6: return allocationRule9_cond_6();
            case 7: return allocationRule9_cond_7();
            case 8: return allocationRule9_cond_8();
            case 9: return allocationRule9_cond_9();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule allocationRule9 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_allocationRule9(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!allocationRule9_cond_1()) return false;
                if (!allocationRule9_cond_3()) return false;
                if (!allocationRule9_cond_7()) return false;
                return true;
            case 2:
                if (!allocationRule9_cond_4()) return false;
                return true;
            case 3:
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_allocationRule9(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!allocationRule9_cond_0()) return false;
                return true;
            case 2:
                if (!allocationRule9_cond_2()) return false;
                return true;
            case 3:
                if (!allocationRule9_cond_5()) return false;
                if (!allocationRule9_cond_6()) return false;
                if (!allocationRule9_cond_8()) return false;
                if (!allocationRule9_cond_9()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule allocationRule9
     */
    private void allocationRule9() {
      System.out.println("allocationRule9 fired");
  	  sss_scheduler_objects_Schedule_1.scheduleLesson(sss_scheduler_objects_Lesson_1, sss_scheduler_objects_Classroom_1, (sss_scheduler_objects_Lesson_1.getClassInSchool()), (sss_scheduler_objects_Lesson_1.getTeacher()), sss_scheduler_objects_LessonHour_1);
  	  modified(sss_scheduler_objects_Schedule_1);
  	  modified(sss_scheduler_objects_Classroom_1);
  	  modified((sss_scheduler_objects_Lesson_1.getClassInSchool()));
  	  modified((sss_scheduler_objects_Lesson_1.getTeacher()));
  	  retract(sss_scheduler_objects_Lesson_1);
      }



    /**
     * The names of the rules in this class file
     */
    private static final String[] File_ruleNames = {
        "allocationRule1",
        "allocationRule2",
        "allocationRule3",
        "allocationRule4",
        "allocationRule5",
        "allocationRule6",
        "allocationRule7",
        "allocationRule8",
        "allocationRule9"
    };

    /**
     * Returns the name of the rules in this class file.
     *
     * @return the name of the rules in this class file.
     */
    public String[] getRuleNames() {
        return File_ruleNames;
    }

    /**
     * The number of declarations of the rules in this class file.
     */
    private static final int[] File_numberOfDeclarations = {
        4,
        4,
        4,
        4,
        4,
        4,
        4,
        4,
        4
    };

    /**
     * Returns the number of declarations of the rules in this class file.
     *
     * @return the number of declarations  of the rules in this class file.
     */
    public int[] getNumberOfDeclarations() {
        return File_numberOfDeclarations;
    }

    /**
     * The number of conditions of the rules in this class file.
     */
    private static final int[] File_numberOfConditions = {
        9,
        9,
        11,
        10,
        10,
        12,
        8,
        8,
        10
    };

    /**
     * Returns the number of conditions of the rules in this class file.
     *
     * @return the number of conditions  of the rules in this class file.
     */
    public int[] getNumberOfConditions() {
        return File_numberOfConditions;
    }

    /**
     * Checks whether a condition of some rule is satisfied.
     *
     * @param ruleIndex the index of the rule to be checked
     * @param condIndex the index of the condition to be checked
     * @return <code>true</code> if the corresponding condition for the
     *          given rule is satisfied. <code>false</code> otherwise.
     */
    public boolean checkCondition(int ruleIndex, int condIndex) {
        switch (ruleIndex) {
            case 0: return allocationRule1_cond(condIndex);
            case 1: return allocationRule2_cond(condIndex);
            case 2: return allocationRule3_cond(condIndex);
            case 3: return allocationRule4_cond(condIndex);
            case 4: return allocationRule5_cond(condIndex);
            case 5: return allocationRule6_cond(condIndex);
            case 6: return allocationRule7_cond(condIndex);
            case 7: return allocationRule8_cond(condIndex);
            case 8: return allocationRule9_cond(condIndex);
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of some rule that depend only on
     * the given object are satisfied.
     *
     * @param ruleIndex the index of the rule to be checked
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          the given rule are satisfied;
     *           <code>false</code> otherwise.
     */
    public boolean checkConditionsOnlyOf(int ruleIndex, int declIndex) {
        switch (ruleIndex) {
            case 0: return checkConditionsOnlyOf_allocationRule1(declIndex);
            case 1: return checkConditionsOnlyOf_allocationRule2(declIndex);
            case 2: return checkConditionsOnlyOf_allocationRule3(declIndex);
            case 3: return checkConditionsOnlyOf_allocationRule4(declIndex);
            case 4: return checkConditionsOnlyOf_allocationRule5(declIndex);
            case 5: return checkConditionsOnlyOf_allocationRule6(declIndex);
            case 6: return checkConditionsOnlyOf_allocationRule7(declIndex);
            case 7: return checkConditionsOnlyOf_allocationRule8(declIndex);
            case 8: return checkConditionsOnlyOf_allocationRule9(declIndex);
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference only the elements declared up to the given index
     * are true.
     *
     * @param ruleIndex the index of the rule to be checked
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all the conditions of a rule which
     *          reference only the elements declared up to the given index
     *          are satisfied; <code>false</code> otherwise.
     */
    public boolean checkCondForDeclaration(int ruleIndex, int declIndex) {
        switch (ruleIndex) {
            case 0: return checkCondForDeclaration_allocationRule1(declIndex);
            case 1: return checkCondForDeclaration_allocationRule2(declIndex);
            case 2: return checkCondForDeclaration_allocationRule3(declIndex);
            case 3: return checkCondForDeclaration_allocationRule4(declIndex);
            case 4: return checkCondForDeclaration_allocationRule5(declIndex);
            case 5: return checkCondForDeclaration_allocationRule6(declIndex);
            case 6: return checkCondForDeclaration_allocationRule7(declIndex);
            case 7: return checkCondForDeclaration_allocationRule8(declIndex);
            case 8: return checkCondForDeclaration_allocationRule9(declIndex);
            default: return false;
        }
    }

    /**
     * Returns the class name of an object declared in a rule.
     *
     * @param ruleIndex the index of the rule
     * @param declIndex the index of the declaration
     * @return the class name of the declared object.
     */
    public String getDeclaredClassName(int ruleIndex, int declIndex) {
        switch (ruleIndex) {
            case 0: return getDeclaredClassName_allocationRule1(declIndex);
            case 1: return getDeclaredClassName_allocationRule2(declIndex);
            case 2: return getDeclaredClassName_allocationRule3(declIndex);
            case 3: return getDeclaredClassName_allocationRule4(declIndex);
            case 4: return getDeclaredClassName_allocationRule5(declIndex);
            case 5: return getDeclaredClassName_allocationRule6(declIndex);
            case 6: return getDeclaredClassName_allocationRule7(declIndex);
            case 7: return getDeclaredClassName_allocationRule8(declIndex);
            case 8: return getDeclaredClassName_allocationRule9(declIndex);
            default: return null;
        }
    }

    /**
     * Returns the class of an object declared in a rule.
     *
     * @param ruleIndex the index of the rule
     * @param declIndex the index of the declaration
     * @return the class of the declared object.
     */
    public Class getDeclaredClass(int ruleIndex, int declIndex) {
        switch (ruleIndex) {
            case 0: return getDeclaredClass_allocationRule1(declIndex);
            case 1: return getDeclaredClass_allocationRule2(declIndex);
            case 2: return getDeclaredClass_allocationRule3(declIndex);
            case 3: return getDeclaredClass_allocationRule4(declIndex);
            case 4: return getDeclaredClass_allocationRule5(declIndex);
            case 5: return getDeclaredClass_allocationRule6(declIndex);
            case 6: return getDeclaredClass_allocationRule7(declIndex);
            case 7: return getDeclaredClass_allocationRule8(declIndex);
            case 8: return getDeclaredClass_allocationRule9(declIndex);
            default: return null;
        }
    }

    /**
     * Fires one of the rules in this rule base.
     *
     * @param ruleIndex the index of the rule to be fired
     */
    protected void internalFireRule(int ruleIndex) {
        switch (ruleIndex) {
            case 0: allocationRule1(); break;
            case 1: allocationRule2(); break;
            case 2: allocationRule3(); break;
            case 3: allocationRule4(); break;
            case 4: allocationRule5(); break;
            case 5: allocationRule6(); break;
            case 6: allocationRule7(); break;
            case 7: allocationRule8(); break;
            case 8: allocationRule9(); break;
        }
    }

    /**
     * Returns the number of rules.
     *
     * @return the number of rules.
     */
    public int getNumberOfRules() {
        return 9;
    }

    /**
     * Returns the identifiers declared in a given rule.
     *
     * @param ruleIndex the index of the rule.
     * @return an array with the identifiers of the rule declarations.
     */
    public String[] getDeclaredIdentifiers(int ruleIndex) {
        switch (ruleIndex) {
            case 0: return getDeclaredIdentifiers_allocationRule1();
            case 1: return getDeclaredIdentifiers_allocationRule2();
            case 2: return getDeclaredIdentifiers_allocationRule3();
            case 3: return getDeclaredIdentifiers_allocationRule4();
            case 4: return getDeclaredIdentifiers_allocationRule5();
            case 5: return getDeclaredIdentifiers_allocationRule6();
            case 6: return getDeclaredIdentifiers_allocationRule7();
            case 7: return getDeclaredIdentifiers_allocationRule8();
            case 8: return getDeclaredIdentifiers_allocationRule9();
            default: return new String[0];
        }
    }

    /**
     * Sets an object that represents a declaration of some rule.
     *
     * @param ruleIndex the index of the rule
     * @param declIndex the index of the declaration in the rule.
     * @param value the value of the object being set.
     */
    public void setObject(int ruleIndex, int declIndex, Object value) {
        switch (ruleIndex) {
            case 0: setObject_allocationRule1(declIndex, value); break;
            case 1: setObject_allocationRule2(declIndex, value); break;
            case 2: setObject_allocationRule3(declIndex, value); break;
            case 3: setObject_allocationRule4(declIndex, value); break;
            case 4: setObject_allocationRule5(declIndex, value); break;
            case 5: setObject_allocationRule6(declIndex, value); break;
            case 6: setObject_allocationRule7(declIndex, value); break;
            case 7: setObject_allocationRule8(declIndex, value); break;
            case 8: setObject_allocationRule9(declIndex, value); break;
        }
    }

    /**
     * Returns an object that represents a declaration of some rule.
     *
     * @param ruleIndex the index of the rule
     * @param declIndex the index of the declaration in the rule.
     * @return the value of the corresponding object.
     */
    public Object getObject(int ruleIndex, int declIndex) {
        switch (ruleIndex) {
            case 0: return getObject_allocationRule1(declIndex);
            case 1: return getObject_allocationRule2(declIndex);
            case 2: return getObject_allocationRule3(declIndex);
            case 3: return getObject_allocationRule4(declIndex);
            case 4: return getObject_allocationRule5(declIndex);
            case 5: return getObject_allocationRule6(declIndex);
            case 6: return getObject_allocationRule7(declIndex);
            case 7: return getObject_allocationRule8(declIndex);
            case 8: return getObject_allocationRule9(declIndex);
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations of
     * some rule.
     *
     * @param ruleIndex the index of the rule
     * @return an object array of the variables bound to the
     *          declarations of some rule.
     */
    public Object[] getObjects(int ruleIndex) {
        switch (ruleIndex) {
            case 0: return getObjects_allocationRule1();
            case 1: return getObjects_allocationRule2();
            case 2: return getObjects_allocationRule3();
            case 3: return getObjects_allocationRule4();
            case 4: return getObjects_allocationRule5();
            case 5: return getObjects_allocationRule6();
            case 6: return getObjects_allocationRule7();
            case 7: return getObjects_allocationRule8();
            case 8: return getObjects_allocationRule9();
            default: return null;
        }
    }
    /**
     * Defines all variables bound to the declarations of
     * some rule.
     *
     * @param ruleIndex the index of the rule
     * @param objects an object array of the variables bound to the
     *          declarations of some rule.
     */
    public void setObjects(int ruleIndex, Object[] objects) {
        switch (ruleIndex) {
            case 0: setObjects_allocationRule1(objects); break;
            case 1: setObjects_allocationRule2(objects); break;
            case 2: setObjects_allocationRule3(objects); break;
            case 3: setObjects_allocationRule4(objects); break;
            case 4: setObjects_allocationRule5(objects); break;
            case 5: setObjects_allocationRule6(objects); break;
            case 6: setObjects_allocationRule7(objects); break;
            case 7: setObjects_allocationRule8(objects); break;
            case 8: setObjects_allocationRule9(objects); break;
        }
    }

    /*
     * The variables declared in the rules.
     */
    private sss.scheduler.objects.Schedule sss_scheduler_objects_Schedule_1;
    private sss.scheduler.objects.Lesson sss_scheduler_objects_Lesson_1;
    private sss.scheduler.objects.Classroom sss_scheduler_objects_Classroom_1;
    private sss.scheduler.objects.LessonHour sss_scheduler_objects_LessonHour_1;

    /**
     * Class constructor.
     *
     * @param knowledgeBase the knowledge base that contains this rule base.
     */
    public Jeops_RuleBase_ClassroomTimeslotAllocationKB(jeops.AbstractKnowledgeBase knowledgeBase) {
        super(knowledgeBase);
    }

}

/**
 * Knowledge base created by JEOPS from file ClassroomTimeslotAllocationKB.rules
 *
 * @version Jan 21, 2014
 */
public class ClassroomTimeslotAllocationKB extends jeops.AbstractKnowledgeBase {

    /**
     * Creates a new knowledge base with the specified conflict set with the
     * desired conflict resolution policy.
     *
     * @param conflictSet a conflict set with the desired resolution policy
     */
    public ClassroomTimeslotAllocationKB(jeops.conflict.ConflictSet conflictSet) {
        super(conflictSet);
    }

    /**
     * Creates a new knowledge base, using the default conflict resolution
     * policy.
     */
    public ClassroomTimeslotAllocationKB() {
        this(new jeops.conflict.DefaultConflictSet());
    }

    /**
     * Factory method used to instantiate the rule base.
     */
    protected jeops.AbstractRuleBase createRuleBase() {
        return new Jeops_RuleBase_ClassroomTimeslotAllocationKB(this);
    }

}
