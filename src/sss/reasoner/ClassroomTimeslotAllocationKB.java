package sss.reasoner;

import sss.scheduler.objects.*;
import sss.scheduler.properties.Availability;

/**
 * Rule base used to allocate a lesson object to a classroom and time slot.
 */
  class Jeops_RuleBase_ClassroomTimeslotAllocationKB extends jeops.AbstractRuleBase {

/* 
 * Allocation rule, class doesn't have this subject at the same day
 * and teacher is already allocated to the classroom right before or after this hour
 */
  
    /**
     * Identifiers of rule CTAR1
     */
    private String[] identifiers_CTAR1 = {
        "schedule",
        "lessonToAllocate",
        "classroom",
        "hour"
    };

    /**
     * Returns the identifiers declared in rule CTAR1
     *
     * @return the identifiers declared in rule CTAR1
     */
    private String[] getDeclaredIdentifiers_CTAR1() {
         return identifiers_CTAR1;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule CTAR1.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_CTAR1(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.Lesson";
            case 2: return "sss.scheduler.objects.Classroom";
            case 3: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule CTAR1.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_CTAR1(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.Lesson.class;
            case 2: return sss.scheduler.objects.Classroom.class;
            case 3: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule CTAR1.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_CTAR1(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 2: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
            case 3: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule CTAR1.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_CTAR1(int index) {
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
     * of rule CTAR1
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_CTAR1() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Classroom_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule CTAR1
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_CTAR1(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[1];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[2];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[3];
    }

    /**
     * Condition 0 of rule CTAR1.<p>
     * The original expression was:<br>
     * <code>classroom.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR1_cond_0() {
        return (sss_scheduler_objects_Classroom_1.isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 1 of rule CTAR1.<p>
     * The original expression was:<br>
     * <code>schedule.teacherScheduledInClassroomBeforeOrAfter(teacher, classroom, hour)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR1_cond_1() {
        return (sss_scheduler_objects_Schedule_1.teacherScheduledInClassroomBeforeOrAfter((sss_scheduler_objects_Lesson_1.getTeacher()), sss_scheduler_objects_Classroom_1, sss_scheduler_objects_LessonHour_1));
    }

    /**
     * Condition 2 of rule CTAR1.<p>
     * The original expression was:<br>
     * <code>!schedule.subjectAllocatedToClassOnWeekday(subject, hour, classToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR1_cond_2() {
        return (!sss_scheduler_objects_Schedule_1.subjectAllocatedToClassOnWeekday((sss_scheduler_objects_Lesson_1.getSubject()), sss_scheduler_objects_LessonHour_1, (sss_scheduler_objects_Lesson_1.getClassInSchool())));
    }

    /**
     * Condition 3 of rule CTAR1.<p>
     * The original expression was:<br>
     * <code>classToAllocate.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR1_cond_3() {
        return ((sss_scheduler_objects_Lesson_1.getClassInSchool()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 4 of rule CTAR1.<p>
     * The original expression was:<br>
     * <code>teacher.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR1_cond_4() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 5 of rule CTAR1.<p>
     * The original expression was:<br>
     * <code>teacher.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR1_cond_5() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 6 of rule CTAR1.<p>
     * The original expression was:<br>
     * <code>!teacher.isScheduled(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR1_cond_6() {
        return (!(sss_scheduler_objects_Lesson_1.getTeacher()).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Checks whether some conditions of rule CTAR1 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR1_cond(int index) {
        switch (index) {
            case 0: return CTAR1_cond_0();
            case 1: return CTAR1_cond_1();
            case 2: return CTAR1_cond_2();
            case 3: return CTAR1_cond_3();
            case 4: return CTAR1_cond_4();
            case 5: return CTAR1_cond_5();
            case 6: return CTAR1_cond_6();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule CTAR1 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_CTAR1(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!CTAR1_cond_4()) return false;
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
    private boolean checkCondForDeclaration_CTAR1(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                if (!CTAR1_cond_0()) return false;
                if (!CTAR1_cond_1()) return false;
                if (!CTAR1_cond_2()) return false;
                if (!CTAR1_cond_3()) return false;
                if (!CTAR1_cond_5()) return false;
                if (!CTAR1_cond_6()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule CTAR1
     */
    private void CTAR1() {
  	  sss_scheduler_objects_Schedule_1.scheduleLesson(sss_scheduler_objects_Lesson_1, sss_scheduler_objects_Classroom_1, (sss_scheduler_objects_Lesson_1.getClassInSchool()), (sss_scheduler_objects_Lesson_1.getTeacher()), sss_scheduler_objects_LessonHour_1);
  	  modified(sss_scheduler_objects_Schedule_1);
  	  modified(sss_scheduler_objects_Classroom_1);
  	  modified((sss_scheduler_objects_Lesson_1.getClassInSchool()));
  	  modified((sss_scheduler_objects_Lesson_1.getTeacher()));
  	  retract(sss_scheduler_objects_Lesson_1);
      }




/* 
 * Allocation rule, class doesn't have this subject at the same day
 * and teacher has already been in the classroom that day 
 */
  
    /**
     * Identifiers of rule CTAR2
     */
    private String[] identifiers_CTAR2 = {
        "schedule",
        "lessonToAllocate",
        "classroom",
        "hour"
    };

    /**
     * Returns the identifiers declared in rule CTAR2
     *
     * @return the identifiers declared in rule CTAR2
     */
    private String[] getDeclaredIdentifiers_CTAR2() {
         return identifiers_CTAR2;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule CTAR2.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_CTAR2(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.Lesson";
            case 2: return "sss.scheduler.objects.Classroom";
            case 3: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule CTAR2.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_CTAR2(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.Lesson.class;
            case 2: return sss.scheduler.objects.Classroom.class;
            case 3: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule CTAR2.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_CTAR2(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 2: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
            case 3: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule CTAR2.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_CTAR2(int index) {
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
     * of rule CTAR2
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_CTAR2() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Classroom_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule CTAR2
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_CTAR2(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[1];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[2];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[3];
    }

    /**
     * Condition 0 of rule CTAR2.<p>
     * The original expression was:<br>
     * <code>classroom.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR2_cond_0() {
        return (sss_scheduler_objects_Classroom_1.isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 1 of rule CTAR2.<p>
     * The original expression was:<br>
     * <code>schedule.teacherAlreadyScheduledInClassroomOnWeekday(teacher, classroom, hour)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR2_cond_1() {
        return (sss_scheduler_objects_Schedule_1.teacherAlreadyScheduledInClassroomOnWeekday((sss_scheduler_objects_Lesson_1.getTeacher()), sss_scheduler_objects_Classroom_1, sss_scheduler_objects_LessonHour_1));
    }

    /**
     * Condition 2 of rule CTAR2.<p>
     * The original expression was:<br>
     * <code>!schedule.subjectAllocatedToClassOnWeekday(subject, hour, classToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR2_cond_2() {
        return (!sss_scheduler_objects_Schedule_1.subjectAllocatedToClassOnWeekday((sss_scheduler_objects_Lesson_1.getSubject()), sss_scheduler_objects_LessonHour_1, (sss_scheduler_objects_Lesson_1.getClassInSchool())));
    }

    /**
     * Condition 3 of rule CTAR2.<p>
     * The original expression was:<br>
     * <code>classToAllocate.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR2_cond_3() {
        return ((sss_scheduler_objects_Lesson_1.getClassInSchool()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 4 of rule CTAR2.<p>
     * The original expression was:<br>
     * <code>teacher.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR2_cond_4() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 5 of rule CTAR2.<p>
     * The original expression was:<br>
     * <code>teacher.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR2_cond_5() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 6 of rule CTAR2.<p>
     * The original expression was:<br>
     * <code>!teacher.isScheduled(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR2_cond_6() {
        return (!(sss_scheduler_objects_Lesson_1.getTeacher()).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Checks whether some conditions of rule CTAR2 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR2_cond(int index) {
        switch (index) {
            case 0: return CTAR2_cond_0();
            case 1: return CTAR2_cond_1();
            case 2: return CTAR2_cond_2();
            case 3: return CTAR2_cond_3();
            case 4: return CTAR2_cond_4();
            case 5: return CTAR2_cond_5();
            case 6: return CTAR2_cond_6();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule CTAR2 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_CTAR2(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!CTAR2_cond_4()) return false;
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
    private boolean checkCondForDeclaration_CTAR2(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                if (!CTAR2_cond_0()) return false;
                if (!CTAR2_cond_1()) return false;
                if (!CTAR2_cond_2()) return false;
                if (!CTAR2_cond_3()) return false;
                if (!CTAR2_cond_5()) return false;
                if (!CTAR2_cond_6()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule CTAR2
     */
    private void CTAR2() {
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
     * Identifiers of rule CTAR3
     */
    private String[] identifiers_CTAR3 = {
        "schedule",
        "lessonToAllocate",
        "classroom",
        "hour"
    };

    /**
     * Returns the identifiers declared in rule CTAR3
     *
     * @return the identifiers declared in rule CTAR3
     */
    private String[] getDeclaredIdentifiers_CTAR3() {
         return identifiers_CTAR3;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule CTAR3.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_CTAR3(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.Lesson";
            case 2: return "sss.scheduler.objects.Classroom";
            case 3: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule CTAR3.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_CTAR3(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.Lesson.class;
            case 2: return sss.scheduler.objects.Classroom.class;
            case 3: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule CTAR3.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_CTAR3(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 2: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
            case 3: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule CTAR3.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_CTAR3(int index) {
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
     * of rule CTAR3
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_CTAR3() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Classroom_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule CTAR3
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_CTAR3(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[1];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[2];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[3];
    }

    /**
     * Condition 0 of rule CTAR3.<p>
     * The original expression was:<br>
     * <code>teacher.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR3_cond_0() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 1 of rule CTAR3.<p>
     * The original expression was:<br>
     * <code>!schedule.subjectAllocatedToClassOnWeekday(subject, hour, classToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR3_cond_1() {
        return (!sss_scheduler_objects_Schedule_1.subjectAllocatedToClassOnWeekday((sss_scheduler_objects_Lesson_1.getSubject()), sss_scheduler_objects_LessonHour_1, (sss_scheduler_objects_Lesson_1.getClassInSchool())));
    }

    /**
     * Condition 2 of rule CTAR3.<p>
     * The original expression was:<br>
     * <code>classroom.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR3_cond_2() {
        return (sss_scheduler_objects_Classroom_1.isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 3 of rule CTAR3.<p>
     * The original expression was:<br>
     * <code>classroom.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR3_cond_3() {
        return (sss_scheduler_objects_Classroom_1.isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 4 of rule CTAR3.<p>
     * The original expression was:<br>
     * <code>classToAllocate.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR3_cond_4() {
        return ((sss_scheduler_objects_Lesson_1.getClassInSchool()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 5 of rule CTAR3.<p>
     * The original expression was:<br>
     * <code>teacher.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR3_cond_5() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 6 of rule CTAR3.<p>
     * The original expression was:<br>
     * <code>!teacher.isScheduled(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR3_cond_6() {
        return (!(sss_scheduler_objects_Lesson_1.getTeacher()).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Checks whether some conditions of rule CTAR3 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR3_cond(int index) {
        switch (index) {
            case 0: return CTAR3_cond_0();
            case 1: return CTAR3_cond_1();
            case 2: return CTAR3_cond_2();
            case 3: return CTAR3_cond_3();
            case 4: return CTAR3_cond_4();
            case 5: return CTAR3_cond_5();
            case 6: return CTAR3_cond_6();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule CTAR3 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_CTAR3(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!CTAR3_cond_0()) return false;
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
    private boolean checkCondForDeclaration_CTAR3(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                if (!CTAR3_cond_3()) return false;
                return true;
            case 3:
                if (!CTAR3_cond_1()) return false;
                if (!CTAR3_cond_2()) return false;
                if (!CTAR3_cond_4()) return false;
                if (!CTAR3_cond_5()) return false;
                if (!CTAR3_cond_6()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule CTAR3
     */
    private void CTAR3() {
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
     * Identifiers of rule CTAR4
     */
    private String[] identifiers_CTAR4 = {
        "schedule",
        "lessonToAllocate",
        "classroom",
        "hour"
    };

    /**
     * Returns the identifiers declared in rule CTAR4
     *
     * @return the identifiers declared in rule CTAR4
     */
    private String[] getDeclaredIdentifiers_CTAR4() {
         return identifiers_CTAR4;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule CTAR4.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_CTAR4(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.Lesson";
            case 2: return "sss.scheduler.objects.Classroom";
            case 3: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule CTAR4.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_CTAR4(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.Lesson.class;
            case 2: return sss.scheduler.objects.Classroom.class;
            case 3: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule CTAR4.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_CTAR4(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 2: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
            case 3: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule CTAR4.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_CTAR4(int index) {
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
     * of rule CTAR4
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_CTAR4() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Classroom_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule CTAR4
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_CTAR4(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[1];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[2];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[3];
    }

    /**
     * Condition 0 of rule CTAR4.<p>
     * The original expression was:<br>
     * <code>!classroom.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR4_cond_0() {
        return (!sss_scheduler_objects_Classroom_1.isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 1 of rule CTAR4.<p>
     * The original expression was:<br>
     * <code>!lessonToAllocate.needsSpecialClassroom()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR4_cond_1() {
        return (!sss_scheduler_objects_Lesson_1.needsSpecialClassroom());
    }

    /**
     * Condition 2 of rule CTAR4.<p>
     * The original expression was:<br>
     * <code>!schedule.subjectAllocatedToClassOnWeekday(subject, hour, classToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR4_cond_2() {
        return (!sss_scheduler_objects_Schedule_1.subjectAllocatedToClassOnWeekday((sss_scheduler_objects_Lesson_1.getSubject()), sss_scheduler_objects_LessonHour_1, (sss_scheduler_objects_Lesson_1.getClassInSchool())));
    }

    /**
     * Condition 3 of rule CTAR4.<p>
     * The original expression was:<br>
     * <code>classroom.isSuitedForGeneralUse()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR4_cond_3() {
        return (sss_scheduler_objects_Classroom_1.isSuitedForGeneralUse());
    }

    /**
     * Condition 4 of rule CTAR4.<p>
     * The original expression was:<br>
     * <code>classroom.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR4_cond_4() {
        return (sss_scheduler_objects_Classroom_1.isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 5 of rule CTAR4.<p>
     * The original expression was:<br>
     * <code>classToAllocate.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR4_cond_5() {
        return ((sss_scheduler_objects_Lesson_1.getClassInSchool()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 6 of rule CTAR4.<p>
     * The original expression was:<br>
     * <code>teacher.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR4_cond_6() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 7 of rule CTAR4.<p>
     * The original expression was:<br>
     * <code>teacher.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR4_cond_7() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 8 of rule CTAR4.<p>
     * The original expression was:<br>
     * <code>!teacher.isScheduled(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR4_cond_8() {
        return (!(sss_scheduler_objects_Lesson_1.getTeacher()).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Checks whether some conditions of rule CTAR4 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR4_cond(int index) {
        switch (index) {
            case 0: return CTAR4_cond_0();
            case 1: return CTAR4_cond_1();
            case 2: return CTAR4_cond_2();
            case 3: return CTAR4_cond_3();
            case 4: return CTAR4_cond_4();
            case 5: return CTAR4_cond_5();
            case 6: return CTAR4_cond_6();
            case 7: return CTAR4_cond_7();
            case 8: return CTAR4_cond_8();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule CTAR4 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_CTAR4(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!CTAR4_cond_1()) return false;
                if (!CTAR4_cond_6()) return false;
                return true;
            case 2:
                if (!CTAR4_cond_3()) return false;
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
    private boolean checkCondForDeclaration_CTAR4(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                if (!CTAR4_cond_0()) return false;
                return true;
            case 3:
                if (!CTAR4_cond_2()) return false;
                if (!CTAR4_cond_4()) return false;
                if (!CTAR4_cond_5()) return false;
                if (!CTAR4_cond_7()) return false;
                if (!CTAR4_cond_8()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule CTAR4
     */
    private void CTAR4() {
  	  sss_scheduler_objects_Schedule_1.scheduleLesson(sss_scheduler_objects_Lesson_1, sss_scheduler_objects_Classroom_1, (sss_scheduler_objects_Lesson_1.getClassInSchool()), (sss_scheduler_objects_Lesson_1.getTeacher()), sss_scheduler_objects_LessonHour_1);
  	  modified(sss_scheduler_objects_Schedule_1);
  	  modified(sss_scheduler_objects_Classroom_1);
  	  modified((sss_scheduler_objects_Lesson_1.getClassInSchool()));
  	  modified((sss_scheduler_objects_Lesson_1.getTeacher()));
  	  retract(sss_scheduler_objects_Lesson_1);
      }

 

/* 
 * Allocation rule, subject without homework on a day where such subjects aren't allocated yet,
 * and teacher is already allocated to the classroom right before or after this hour
 */
   
    /**
     * Identifiers of rule CTAR5
     */
    private String[] identifiers_CTAR5 = {
        "schedule",
        "lessonToAllocate",
        "classroom",
        "hour"
    };

    /**
     * Returns the identifiers declared in rule CTAR5
     *
     * @return the identifiers declared in rule CTAR5
     */
    private String[] getDeclaredIdentifiers_CTAR5() {
         return identifiers_CTAR5;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule CTAR5.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_CTAR5(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.Lesson";
            case 2: return "sss.scheduler.objects.Classroom";
            case 3: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule CTAR5.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_CTAR5(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.Lesson.class;
            case 2: return sss.scheduler.objects.Classroom.class;
            case 3: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule CTAR5.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_CTAR5(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 2: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
            case 3: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule CTAR5.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_CTAR5(int index) {
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
     * of rule CTAR5
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_CTAR5() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Classroom_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule CTAR5
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_CTAR5(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[1];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[2];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[3];
    }

    /**
     * Condition 0 of rule CTAR5.<p>
     * The original expression was:<br>
     * <code>!subject.requiresHomework()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR5_cond_0() {
        return (!(sss_scheduler_objects_Lesson_1.getSubject()).requiresHomework());
    }

    /**
     * Condition 1 of rule CTAR5.<p>
     * The original expression was:<br>
     * <code>schedule.noClassesWithoutHomeworkOnWeekday(classToAllocate, hour)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR5_cond_1() {
        return (sss_scheduler_objects_Schedule_1.noClassesWithoutHomeworkOnWeekday((sss_scheduler_objects_Lesson_1.getClassInSchool()), sss_scheduler_objects_LessonHour_1));
    }

    /**
     * Condition 2 of rule CTAR5.<p>
     * The original expression was:<br>
     * <code>classroom.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR5_cond_2() {
        return (sss_scheduler_objects_Classroom_1.isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 3 of rule CTAR5.<p>
     * The original expression was:<br>
     * <code>schedule.teacherScheduledInClassroomBeforeOrAfter(teacher, classroom, hour)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR5_cond_3() {
        return (sss_scheduler_objects_Schedule_1.teacherScheduledInClassroomBeforeOrAfter((sss_scheduler_objects_Lesson_1.getTeacher()), sss_scheduler_objects_Classroom_1, sss_scheduler_objects_LessonHour_1));
    }

    /**
     * Condition 4 of rule CTAR5.<p>
     * The original expression was:<br>
     * <code>classToAllocate.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR5_cond_4() {
        return ((sss_scheduler_objects_Lesson_1.getClassInSchool()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 5 of rule CTAR5.<p>
     * The original expression was:<br>
     * <code>teacher.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR5_cond_5() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 6 of rule CTAR5.<p>
     * The original expression was:<br>
     * <code>teacher.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR5_cond_6() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 7 of rule CTAR5.<p>
     * The original expression was:<br>
     * <code>!teacher.isScheduled(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR5_cond_7() {
        return (!(sss_scheduler_objects_Lesson_1.getTeacher()).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Checks whether some conditions of rule CTAR5 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR5_cond(int index) {
        switch (index) {
            case 0: return CTAR5_cond_0();
            case 1: return CTAR5_cond_1();
            case 2: return CTAR5_cond_2();
            case 3: return CTAR5_cond_3();
            case 4: return CTAR5_cond_4();
            case 5: return CTAR5_cond_5();
            case 6: return CTAR5_cond_6();
            case 7: return CTAR5_cond_7();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule CTAR5 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_CTAR5(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!CTAR5_cond_0()) return false;
                if (!CTAR5_cond_5()) return false;
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
    private boolean checkCondForDeclaration_CTAR5(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                if (!CTAR5_cond_1()) return false;
                if (!CTAR5_cond_2()) return false;
                if (!CTAR5_cond_3()) return false;
                if (!CTAR5_cond_4()) return false;
                if (!CTAR5_cond_6()) return false;
                if (!CTAR5_cond_7()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule CTAR5
     */
    private void CTAR5() {
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
     * Identifiers of rule CTAR6
     */
    private String[] identifiers_CTAR6 = {
        "schedule",
        "lessonToAllocate",
        "classroom",
        "hour"
    };

    /**
     * Returns the identifiers declared in rule CTAR6
     *
     * @return the identifiers declared in rule CTAR6
     */
    private String[] getDeclaredIdentifiers_CTAR6() {
         return identifiers_CTAR6;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule CTAR6.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_CTAR6(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.Lesson";
            case 2: return "sss.scheduler.objects.Classroom";
            case 3: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule CTAR6.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_CTAR6(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.Lesson.class;
            case 2: return sss.scheduler.objects.Classroom.class;
            case 3: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule CTAR6.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_CTAR6(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 2: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
            case 3: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule CTAR6.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_CTAR6(int index) {
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
     * of rule CTAR6
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_CTAR6() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Classroom_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule CTAR6
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_CTAR6(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[1];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[2];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[3];
    }

    /**
     * Condition 0 of rule CTAR6.<p>
     * The original expression was:<br>
     * <code>!subject.requiresHomework()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR6_cond_0() {
        return (!(sss_scheduler_objects_Lesson_1.getSubject()).requiresHomework());
    }

    /**
     * Condition 1 of rule CTAR6.<p>
     * The original expression was:<br>
     * <code>schedule.noClassesWithoutHomeworkOnWeekday(classToAllocate, hour)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR6_cond_1() {
        return (sss_scheduler_objects_Schedule_1.noClassesWithoutHomeworkOnWeekday((sss_scheduler_objects_Lesson_1.getClassInSchool()), sss_scheduler_objects_LessonHour_1));
    }

    /**
     * Condition 2 of rule CTAR6.<p>
     * The original expression was:<br>
     * <code>classroom.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR6_cond_2() {
        return (sss_scheduler_objects_Classroom_1.isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 3 of rule CTAR6.<p>
     * The original expression was:<br>
     * <code>schedule.teacherAlreadyScheduledInClassroomOnWeekday(teacher, classroom, hour)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR6_cond_3() {
        return (sss_scheduler_objects_Schedule_1.teacherAlreadyScheduledInClassroomOnWeekday((sss_scheduler_objects_Lesson_1.getTeacher()), sss_scheduler_objects_Classroom_1, sss_scheduler_objects_LessonHour_1));
    }

    /**
     * Condition 4 of rule CTAR6.<p>
     * The original expression was:<br>
     * <code>classToAllocate.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR6_cond_4() {
        return ((sss_scheduler_objects_Lesson_1.getClassInSchool()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 5 of rule CTAR6.<p>
     * The original expression was:<br>
     * <code>teacher.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR6_cond_5() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 6 of rule CTAR6.<p>
     * The original expression was:<br>
     * <code>teacher.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR6_cond_6() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 7 of rule CTAR6.<p>
     * The original expression was:<br>
     * <code>!teacher.isScheduled(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR6_cond_7() {
        return (!(sss_scheduler_objects_Lesson_1.getTeacher()).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Checks whether some conditions of rule CTAR6 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR6_cond(int index) {
        switch (index) {
            case 0: return CTAR6_cond_0();
            case 1: return CTAR6_cond_1();
            case 2: return CTAR6_cond_2();
            case 3: return CTAR6_cond_3();
            case 4: return CTAR6_cond_4();
            case 5: return CTAR6_cond_5();
            case 6: return CTAR6_cond_6();
            case 7: return CTAR6_cond_7();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule CTAR6 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_CTAR6(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!CTAR6_cond_0()) return false;
                if (!CTAR6_cond_5()) return false;
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
    private boolean checkCondForDeclaration_CTAR6(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                if (!CTAR6_cond_1()) return false;
                if (!CTAR6_cond_2()) return false;
                if (!CTAR6_cond_3()) return false;
                if (!CTAR6_cond_4()) return false;
                if (!CTAR6_cond_6()) return false;
                if (!CTAR6_cond_7()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule CTAR6
     */
    private void CTAR6() {
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
     * Identifiers of rule CTAR7
     */
    private String[] identifiers_CTAR7 = {
        "schedule",
        "lessonToAllocate",
        "classroom",
        "hour"
    };

    /**
     * Returns the identifiers declared in rule CTAR7
     *
     * @return the identifiers declared in rule CTAR7
     */
    private String[] getDeclaredIdentifiers_CTAR7() {
         return identifiers_CTAR7;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule CTAR7.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_CTAR7(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.Lesson";
            case 2: return "sss.scheduler.objects.Classroom";
            case 3: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule CTAR7.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_CTAR7(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.Lesson.class;
            case 2: return sss.scheduler.objects.Classroom.class;
            case 3: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule CTAR7.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_CTAR7(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 2: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
            case 3: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule CTAR7.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_CTAR7(int index) {
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
     * of rule CTAR7
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_CTAR7() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Classroom_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule CTAR7
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_CTAR7(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[1];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[2];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[3];
    }

    /**
     * Condition 0 of rule CTAR7.<p>
     * The original expression was:<br>
     * <code>teacher.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR7_cond_0() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 1 of rule CTAR7.<p>
     * The original expression was:<br>
     * <code>!subject.requiresHomework()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR7_cond_1() {
        return (!(sss_scheduler_objects_Lesson_1.getSubject()).requiresHomework());
    }

    /**
     * Condition 2 of rule CTAR7.<p>
     * The original expression was:<br>
     * <code>schedule.noClassesWithoutHomeworkOnWeekday(classToAllocate, hour)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR7_cond_2() {
        return (sss_scheduler_objects_Schedule_1.noClassesWithoutHomeworkOnWeekday((sss_scheduler_objects_Lesson_1.getClassInSchool()), sss_scheduler_objects_LessonHour_1));
    }

    /**
     * Condition 3 of rule CTAR7.<p>
     * The original expression was:<br>
     * <code>classroom.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR7_cond_3() {
        return (sss_scheduler_objects_Classroom_1.isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 4 of rule CTAR7.<p>
     * The original expression was:<br>
     * <code>classroom.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR7_cond_4() {
        return (sss_scheduler_objects_Classroom_1.isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 5 of rule CTAR7.<p>
     * The original expression was:<br>
     * <code>classToAllocate.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR7_cond_5() {
        return ((sss_scheduler_objects_Lesson_1.getClassInSchool()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 6 of rule CTAR7.<p>
     * The original expression was:<br>
     * <code>teacher.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR7_cond_6() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 7 of rule CTAR7.<p>
     * The original expression was:<br>
     * <code>!teacher.isScheduled(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR7_cond_7() {
        return (!(sss_scheduler_objects_Lesson_1.getTeacher()).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Checks whether some conditions of rule CTAR7 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR7_cond(int index) {
        switch (index) {
            case 0: return CTAR7_cond_0();
            case 1: return CTAR7_cond_1();
            case 2: return CTAR7_cond_2();
            case 3: return CTAR7_cond_3();
            case 4: return CTAR7_cond_4();
            case 5: return CTAR7_cond_5();
            case 6: return CTAR7_cond_6();
            case 7: return CTAR7_cond_7();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule CTAR7 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_CTAR7(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!CTAR7_cond_0()) return false;
                if (!CTAR7_cond_1()) return false;
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
    private boolean checkCondForDeclaration_CTAR7(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                if (!CTAR7_cond_4()) return false;
                return true;
            case 3:
                if (!CTAR7_cond_2()) return false;
                if (!CTAR7_cond_3()) return false;
                if (!CTAR7_cond_5()) return false;
                if (!CTAR7_cond_6()) return false;
                if (!CTAR7_cond_7()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule CTAR7
     */
    private void CTAR7() {
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
     * Identifiers of rule CTAR8
     */
    private String[] identifiers_CTAR8 = {
        "schedule",
        "lessonToAllocate",
        "classroom",
        "hour"
    };

    /**
     * Returns the identifiers declared in rule CTAR8
     *
     * @return the identifiers declared in rule CTAR8
     */
    private String[] getDeclaredIdentifiers_CTAR8() {
         return identifiers_CTAR8;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule CTAR8.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_CTAR8(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.Lesson";
            case 2: return "sss.scheduler.objects.Classroom";
            case 3: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule CTAR8.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_CTAR8(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.Lesson.class;
            case 2: return sss.scheduler.objects.Classroom.class;
            case 3: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule CTAR8.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_CTAR8(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 2: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
            case 3: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule CTAR8.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_CTAR8(int index) {
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
     * of rule CTAR8
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_CTAR8() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Classroom_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule CTAR8
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_CTAR8(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[1];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[2];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[3];
    }

    /**
     * Condition 0 of rule CTAR8.<p>
     * The original expression was:<br>
     * <code>!subject.requiresHomework()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR8_cond_0() {
        return (!(sss_scheduler_objects_Lesson_1.getSubject()).requiresHomework());
    }

    /**
     * Condition 1 of rule CTAR8.<p>
     * The original expression was:<br>
     * <code>schedule.noClassesWithoutHomeworkOnWeekday(classToAllocate, hour)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR8_cond_1() {
        return (sss_scheduler_objects_Schedule_1.noClassesWithoutHomeworkOnWeekday((sss_scheduler_objects_Lesson_1.getClassInSchool()), sss_scheduler_objects_LessonHour_1));
    }

    /**
     * Condition 2 of rule CTAR8.<p>
     * The original expression was:<br>
     * <code>!classroom.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR8_cond_2() {
        return (!sss_scheduler_objects_Classroom_1.isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 3 of rule CTAR8.<p>
     * The original expression was:<br>
     * <code>!lessonToAllocate.needsSpecialClassroom()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR8_cond_3() {
        return (!sss_scheduler_objects_Lesson_1.needsSpecialClassroom());
    }

    /**
     * Condition 4 of rule CTAR8.<p>
     * The original expression was:<br>
     * <code>classroom.isSuitedForGeneralUse()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR8_cond_4() {
        return (sss_scheduler_objects_Classroom_1.isSuitedForGeneralUse());
    }

    /**
     * Condition 5 of rule CTAR8.<p>
     * The original expression was:<br>
     * <code>classroom.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR8_cond_5() {
        return (sss_scheduler_objects_Classroom_1.isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 6 of rule CTAR8.<p>
     * The original expression was:<br>
     * <code>classToAllocate.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR8_cond_6() {
        return ((sss_scheduler_objects_Lesson_1.getClassInSchool()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 7 of rule CTAR8.<p>
     * The original expression was:<br>
     * <code>teacher.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR8_cond_7() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 8 of rule CTAR8.<p>
     * The original expression was:<br>
     * <code>teacher.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR8_cond_8() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 9 of rule CTAR8.<p>
     * The original expression was:<br>
     * <code>!teacher.isScheduled(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR8_cond_9() {
        return (!(sss_scheduler_objects_Lesson_1.getTeacher()).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Checks whether some conditions of rule CTAR8 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR8_cond(int index) {
        switch (index) {
            case 0: return CTAR8_cond_0();
            case 1: return CTAR8_cond_1();
            case 2: return CTAR8_cond_2();
            case 3: return CTAR8_cond_3();
            case 4: return CTAR8_cond_4();
            case 5: return CTAR8_cond_5();
            case 6: return CTAR8_cond_6();
            case 7: return CTAR8_cond_7();
            case 8: return CTAR8_cond_8();
            case 9: return CTAR8_cond_9();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule CTAR8 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_CTAR8(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!CTAR8_cond_0()) return false;
                if (!CTAR8_cond_3()) return false;
                if (!CTAR8_cond_7()) return false;
                return true;
            case 2:
                if (!CTAR8_cond_4()) return false;
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
    private boolean checkCondForDeclaration_CTAR8(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                if (!CTAR8_cond_2()) return false;
                return true;
            case 3:
                if (!CTAR8_cond_1()) return false;
                if (!CTAR8_cond_5()) return false;
                if (!CTAR8_cond_6()) return false;
                if (!CTAR8_cond_8()) return false;
                if (!CTAR8_cond_9()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule CTAR8
     */
    private void CTAR8() {
  	  sss_scheduler_objects_Schedule_1.scheduleLesson(sss_scheduler_objects_Lesson_1, sss_scheduler_objects_Classroom_1, (sss_scheduler_objects_Lesson_1.getClassInSchool()), (sss_scheduler_objects_Lesson_1.getTeacher()), sss_scheduler_objects_LessonHour_1);
  	  modified(sss_scheduler_objects_Schedule_1);
  	  modified(sss_scheduler_objects_Classroom_1);
  	  modified((sss_scheduler_objects_Lesson_1.getClassInSchool()));
  	  modified((sss_scheduler_objects_Lesson_1.getTeacher()));
  	  retract(sss_scheduler_objects_Lesson_1);
      }



/* Allocation rule, teacher is already allocated to the classroom right before or after this hour */
  
    /**
     * Identifiers of rule CTAR9
     */
    private String[] identifiers_CTAR9 = {
        "schedule",
        "lessonToAllocate",
        "classroom",
        "hour"
    };

    /**
     * Returns the identifiers declared in rule CTAR9
     *
     * @return the identifiers declared in rule CTAR9
     */
    private String[] getDeclaredIdentifiers_CTAR9() {
         return identifiers_CTAR9;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule CTAR9.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_CTAR9(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.Lesson";
            case 2: return "sss.scheduler.objects.Classroom";
            case 3: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule CTAR9.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_CTAR9(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.Lesson.class;
            case 2: return sss.scheduler.objects.Classroom.class;
            case 3: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule CTAR9.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_CTAR9(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 2: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
            case 3: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule CTAR9.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_CTAR9(int index) {
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
     * of rule CTAR9
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_CTAR9() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Classroom_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule CTAR9
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_CTAR9(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[1];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[2];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[3];
    }

    /**
     * Condition 0 of rule CTAR9.<p>
     * The original expression was:<br>
     * <code>classroom.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR9_cond_0() {
        return (sss_scheduler_objects_Classroom_1.isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 1 of rule CTAR9.<p>
     * The original expression was:<br>
     * <code>schedule.teacherScheduledInClassroomBeforeOrAfter(teacher, classroom, hour)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR9_cond_1() {
        return (sss_scheduler_objects_Schedule_1.teacherScheduledInClassroomBeforeOrAfter((sss_scheduler_objects_Lesson_1.getTeacher()), sss_scheduler_objects_Classroom_1, sss_scheduler_objects_LessonHour_1));
    }

    /**
     * Condition 2 of rule CTAR9.<p>
     * The original expression was:<br>
     * <code>classToAllocate.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR9_cond_2() {
        return ((sss_scheduler_objects_Lesson_1.getClassInSchool()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 3 of rule CTAR9.<p>
     * The original expression was:<br>
     * <code>teacher.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR9_cond_3() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 4 of rule CTAR9.<p>
     * The original expression was:<br>
     * <code>teacher.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR9_cond_4() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 5 of rule CTAR9.<p>
     * The original expression was:<br>
     * <code>!teacher.isScheduled(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR9_cond_5() {
        return (!(sss_scheduler_objects_Lesson_1.getTeacher()).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Checks whether some conditions of rule CTAR9 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR9_cond(int index) {
        switch (index) {
            case 0: return CTAR9_cond_0();
            case 1: return CTAR9_cond_1();
            case 2: return CTAR9_cond_2();
            case 3: return CTAR9_cond_3();
            case 4: return CTAR9_cond_4();
            case 5: return CTAR9_cond_5();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule CTAR9 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_CTAR9(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!CTAR9_cond_3()) return false;
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
    private boolean checkCondForDeclaration_CTAR9(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                if (!CTAR9_cond_0()) return false;
                if (!CTAR9_cond_1()) return false;
                if (!CTAR9_cond_2()) return false;
                if (!CTAR9_cond_4()) return false;
                if (!CTAR9_cond_5()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule CTAR9
     */
    private void CTAR9() {
  	  sss_scheduler_objects_Schedule_1.scheduleLesson(sss_scheduler_objects_Lesson_1, sss_scheduler_objects_Classroom_1, (sss_scheduler_objects_Lesson_1.getClassInSchool()), (sss_scheduler_objects_Lesson_1.getTeacher()), sss_scheduler_objects_LessonHour_1);
  	  modified(sss_scheduler_objects_Schedule_1);
  	  modified(sss_scheduler_objects_Classroom_1);
  	  modified((sss_scheduler_objects_Lesson_1.getClassInSchool()));
  	  modified((sss_scheduler_objects_Lesson_1.getTeacher()));
  	  retract(sss_scheduler_objects_Lesson_1);
      }



/* Allocation rule, teacher has already been in the classroom that day */
  
    /**
     * Identifiers of rule CTAR10
     */
    private String[] identifiers_CTAR10 = {
        "schedule",
        "lessonToAllocate",
        "classroom",
        "hour"
    };

    /**
     * Returns the identifiers declared in rule CTAR10
     *
     * @return the identifiers declared in rule CTAR10
     */
    private String[] getDeclaredIdentifiers_CTAR10() {
         return identifiers_CTAR10;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule CTAR10.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_CTAR10(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.Lesson";
            case 2: return "sss.scheduler.objects.Classroom";
            case 3: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule CTAR10.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_CTAR10(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.Lesson.class;
            case 2: return sss.scheduler.objects.Classroom.class;
            case 3: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule CTAR10.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_CTAR10(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 2: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
            case 3: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule CTAR10.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_CTAR10(int index) {
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
     * of rule CTAR10
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_CTAR10() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Classroom_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule CTAR10
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_CTAR10(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[1];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[2];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[3];
    }

    /**
     * Condition 0 of rule CTAR10.<p>
     * The original expression was:<br>
     * <code>classroom.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR10_cond_0() {
        return (sss_scheduler_objects_Classroom_1.isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 1 of rule CTAR10.<p>
     * The original expression was:<br>
     * <code>schedule.teacherAlreadyScheduledInClassroomOnWeekday(teacher, classroom, hour)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR10_cond_1() {
        return (sss_scheduler_objects_Schedule_1.teacherAlreadyScheduledInClassroomOnWeekday((sss_scheduler_objects_Lesson_1.getTeacher()), sss_scheduler_objects_Classroom_1, sss_scheduler_objects_LessonHour_1));
    }

    /**
     * Condition 2 of rule CTAR10.<p>
     * The original expression was:<br>
     * <code>classToAllocate.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR10_cond_2() {
        return ((sss_scheduler_objects_Lesson_1.getClassInSchool()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 3 of rule CTAR10.<p>
     * The original expression was:<br>
     * <code>teacher.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR10_cond_3() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 4 of rule CTAR10.<p>
     * The original expression was:<br>
     * <code>teacher.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR10_cond_4() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 5 of rule CTAR10.<p>
     * The original expression was:<br>
     * <code>!teacher.isScheduled(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR10_cond_5() {
        return (!(sss_scheduler_objects_Lesson_1.getTeacher()).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Checks whether some conditions of rule CTAR10 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR10_cond(int index) {
        switch (index) {
            case 0: return CTAR10_cond_0();
            case 1: return CTAR10_cond_1();
            case 2: return CTAR10_cond_2();
            case 3: return CTAR10_cond_3();
            case 4: return CTAR10_cond_4();
            case 5: return CTAR10_cond_5();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule CTAR10 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_CTAR10(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!CTAR10_cond_3()) return false;
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
    private boolean checkCondForDeclaration_CTAR10(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                if (!CTAR10_cond_0()) return false;
                if (!CTAR10_cond_1()) return false;
                if (!CTAR10_cond_2()) return false;
                if (!CTAR10_cond_4()) return false;
                if (!CTAR10_cond_5()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule CTAR10
     */
    private void CTAR10() {
  	  sss_scheduler_objects_Schedule_1.scheduleLesson(sss_scheduler_objects_Lesson_1, sss_scheduler_objects_Classroom_1, (sss_scheduler_objects_Lesson_1.getClassInSchool()), (sss_scheduler_objects_Lesson_1.getTeacher()), sss_scheduler_objects_LessonHour_1);
  	  modified(sss_scheduler_objects_Schedule_1);
  	  modified(sss_scheduler_objects_Classroom_1);
  	  modified((sss_scheduler_objects_Lesson_1.getClassInSchool()));
  	  modified((sss_scheduler_objects_Lesson_1.getTeacher()));
  	  retract(sss_scheduler_objects_Lesson_1);
      }



/* Allocation rule, classroom is suited specially for this lesson */
  
    /**
     * Identifiers of rule CTAR11
     */
    private String[] identifiers_CTAR11 = {
        "schedule",
        "lessonToAllocate",
        "classroom",
        "hour"
    };

    /**
     * Returns the identifiers declared in rule CTAR11
     *
     * @return the identifiers declared in rule CTAR11
     */
    private String[] getDeclaredIdentifiers_CTAR11() {
         return identifiers_CTAR11;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule CTAR11.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_CTAR11(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.Lesson";
            case 2: return "sss.scheduler.objects.Classroom";
            case 3: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule CTAR11.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_CTAR11(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.Lesson.class;
            case 2: return sss.scheduler.objects.Classroom.class;
            case 3: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule CTAR11.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_CTAR11(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 2: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
            case 3: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule CTAR11.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_CTAR11(int index) {
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
     * of rule CTAR11
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_CTAR11() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Classroom_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule CTAR11
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_CTAR11(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[1];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[2];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[3];
    }

    /**
     * Condition 0 of rule CTAR11.<p>
     * The original expression was:<br>
     * <code>teacher.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR11_cond_0() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 1 of rule CTAR11.<p>
     * The original expression was:<br>
     * <code>classroom.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR11_cond_1() {
        return (sss_scheduler_objects_Classroom_1.isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 2 of rule CTAR11.<p>
     * The original expression was:<br>
     * <code>classroom.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR11_cond_2() {
        return (sss_scheduler_objects_Classroom_1.isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 3 of rule CTAR11.<p>
     * The original expression was:<br>
     * <code>classToAllocate.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR11_cond_3() {
        return ((sss_scheduler_objects_Lesson_1.getClassInSchool()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 4 of rule CTAR11.<p>
     * The original expression was:<br>
     * <code>teacher.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR11_cond_4() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 5 of rule CTAR11.<p>
     * The original expression was:<br>
     * <code>!teacher.isScheduled(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR11_cond_5() {
        return (!(sss_scheduler_objects_Lesson_1.getTeacher()).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Checks whether some conditions of rule CTAR11 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR11_cond(int index) {
        switch (index) {
            case 0: return CTAR11_cond_0();
            case 1: return CTAR11_cond_1();
            case 2: return CTAR11_cond_2();
            case 3: return CTAR11_cond_3();
            case 4: return CTAR11_cond_4();
            case 5: return CTAR11_cond_5();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule CTAR11 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_CTAR11(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!CTAR11_cond_0()) return false;
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
    private boolean checkCondForDeclaration_CTAR11(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                if (!CTAR11_cond_2()) return false;
                return true;
            case 3:
                if (!CTAR11_cond_1()) return false;
                if (!CTAR11_cond_3()) return false;
                if (!CTAR11_cond_4()) return false;
                if (!CTAR11_cond_5()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule CTAR11
     */
    private void CTAR11() {
  	  sss_scheduler_objects_Schedule_1.scheduleLesson(sss_scheduler_objects_Lesson_1, sss_scheduler_objects_Classroom_1, (sss_scheduler_objects_Lesson_1.getClassInSchool()), (sss_scheduler_objects_Lesson_1.getTeacher()), sss_scheduler_objects_LessonHour_1);
  	  modified(sss_scheduler_objects_Schedule_1);
  	  modified(sss_scheduler_objects_Classroom_1);
  	  modified((sss_scheduler_objects_Lesson_1.getClassInSchool()));
  	  modified((sss_scheduler_objects_Lesson_1.getTeacher()));
  	  retract(sss_scheduler_objects_Lesson_1);
      }




/* Allocation rule, put lesson in classroom for general use */
  
    /**
     * Identifiers of rule CTAR12
     */
    private String[] identifiers_CTAR12 = {
        "schedule",
        "lessonToAllocate",
        "classroom",
        "hour"
    };

    /**
     * Returns the identifiers declared in rule CTAR12
     *
     * @return the identifiers declared in rule CTAR12
     */
    private String[] getDeclaredIdentifiers_CTAR12() {
         return identifiers_CTAR12;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule CTAR12.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_CTAR12(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.Lesson";
            case 2: return "sss.scheduler.objects.Classroom";
            case 3: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule CTAR12.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_CTAR12(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.Lesson.class;
            case 2: return sss.scheduler.objects.Classroom.class;
            case 3: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule CTAR12.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_CTAR12(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 2: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
            case 3: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule CTAR12.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_CTAR12(int index) {
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
     * of rule CTAR12
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_CTAR12() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Classroom_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule CTAR12
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_CTAR12(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[1];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[2];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[3];
    }

    /**
     * Condition 0 of rule CTAR12.<p>
     * The original expression was:<br>
     * <code>!classroom.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR12_cond_0() {
        return (!sss_scheduler_objects_Classroom_1.isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 1 of rule CTAR12.<p>
     * The original expression was:<br>
     * <code>!lessonToAllocate.needsSpecialClassroom()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR12_cond_1() {
        return (!sss_scheduler_objects_Lesson_1.needsSpecialClassroom());
    }

    /**
     * Condition 2 of rule CTAR12.<p>
     * The original expression was:<br>
     * <code>classroom.isSuitedForGeneralUse()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR12_cond_2() {
        return (sss_scheduler_objects_Classroom_1.isSuitedForGeneralUse());
    }

    /**
     * Condition 3 of rule CTAR12.<p>
     * The original expression was:<br>
     * <code>classroom.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR12_cond_3() {
        return (sss_scheduler_objects_Classroom_1.isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 4 of rule CTAR12.<p>
     * The original expression was:<br>
     * <code>classToAllocate.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR12_cond_4() {
        return ((sss_scheduler_objects_Lesson_1.getClassInSchool()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 5 of rule CTAR12.<p>
     * The original expression was:<br>
     * <code>teacher.isSuitedFor(lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR12_cond_5() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 6 of rule CTAR12.<p>
     * The original expression was:<br>
     * <code>teacher.isAvailable(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR12_cond_6() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 7 of rule CTAR12.<p>
     * The original expression was:<br>
     * <code>!teacher.isScheduled(hour, lessonToAllocate)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR12_cond_7() {
        return (!(sss_scheduler_objects_Lesson_1.getTeacher()).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Checks whether some conditions of rule CTAR12 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean CTAR12_cond(int index) {
        switch (index) {
            case 0: return CTAR12_cond_0();
            case 1: return CTAR12_cond_1();
            case 2: return CTAR12_cond_2();
            case 3: return CTAR12_cond_3();
            case 4: return CTAR12_cond_4();
            case 5: return CTAR12_cond_5();
            case 6: return CTAR12_cond_6();
            case 7: return CTAR12_cond_7();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule CTAR12 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_CTAR12(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!CTAR12_cond_1()) return false;
                if (!CTAR12_cond_5()) return false;
                return true;
            case 2:
                if (!CTAR12_cond_2()) return false;
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
    private boolean checkCondForDeclaration_CTAR12(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                if (!CTAR12_cond_0()) return false;
                return true;
            case 3:
                if (!CTAR12_cond_3()) return false;
                if (!CTAR12_cond_4()) return false;
                if (!CTAR12_cond_6()) return false;
                if (!CTAR12_cond_7()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule CTAR12
     */
    private void CTAR12() {
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
        "CTAR1",
        "CTAR2",
        "CTAR3",
        "CTAR4",
        "CTAR5",
        "CTAR6",
        "CTAR7",
        "CTAR8",
        "CTAR9",
        "CTAR10",
        "CTAR11",
        "CTAR12"
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
        7,
        7,
        7,
        9,
        8,
        8,
        8,
        10,
        6,
        6,
        6,
        8
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
            case 0: return CTAR1_cond(condIndex);
            case 1: return CTAR2_cond(condIndex);
            case 2: return CTAR3_cond(condIndex);
            case 3: return CTAR4_cond(condIndex);
            case 4: return CTAR5_cond(condIndex);
            case 5: return CTAR6_cond(condIndex);
            case 6: return CTAR7_cond(condIndex);
            case 7: return CTAR8_cond(condIndex);
            case 8: return CTAR9_cond(condIndex);
            case 9: return CTAR10_cond(condIndex);
            case 10: return CTAR11_cond(condIndex);
            case 11: return CTAR12_cond(condIndex);
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
            case 0: return checkConditionsOnlyOf_CTAR1(declIndex);
            case 1: return checkConditionsOnlyOf_CTAR2(declIndex);
            case 2: return checkConditionsOnlyOf_CTAR3(declIndex);
            case 3: return checkConditionsOnlyOf_CTAR4(declIndex);
            case 4: return checkConditionsOnlyOf_CTAR5(declIndex);
            case 5: return checkConditionsOnlyOf_CTAR6(declIndex);
            case 6: return checkConditionsOnlyOf_CTAR7(declIndex);
            case 7: return checkConditionsOnlyOf_CTAR8(declIndex);
            case 8: return checkConditionsOnlyOf_CTAR9(declIndex);
            case 9: return checkConditionsOnlyOf_CTAR10(declIndex);
            case 10: return checkConditionsOnlyOf_CTAR11(declIndex);
            case 11: return checkConditionsOnlyOf_CTAR12(declIndex);
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
            case 0: return checkCondForDeclaration_CTAR1(declIndex);
            case 1: return checkCondForDeclaration_CTAR2(declIndex);
            case 2: return checkCondForDeclaration_CTAR3(declIndex);
            case 3: return checkCondForDeclaration_CTAR4(declIndex);
            case 4: return checkCondForDeclaration_CTAR5(declIndex);
            case 5: return checkCondForDeclaration_CTAR6(declIndex);
            case 6: return checkCondForDeclaration_CTAR7(declIndex);
            case 7: return checkCondForDeclaration_CTAR8(declIndex);
            case 8: return checkCondForDeclaration_CTAR9(declIndex);
            case 9: return checkCondForDeclaration_CTAR10(declIndex);
            case 10: return checkCondForDeclaration_CTAR11(declIndex);
            case 11: return checkCondForDeclaration_CTAR12(declIndex);
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
            case 0: return getDeclaredClassName_CTAR1(declIndex);
            case 1: return getDeclaredClassName_CTAR2(declIndex);
            case 2: return getDeclaredClassName_CTAR3(declIndex);
            case 3: return getDeclaredClassName_CTAR4(declIndex);
            case 4: return getDeclaredClassName_CTAR5(declIndex);
            case 5: return getDeclaredClassName_CTAR6(declIndex);
            case 6: return getDeclaredClassName_CTAR7(declIndex);
            case 7: return getDeclaredClassName_CTAR8(declIndex);
            case 8: return getDeclaredClassName_CTAR9(declIndex);
            case 9: return getDeclaredClassName_CTAR10(declIndex);
            case 10: return getDeclaredClassName_CTAR11(declIndex);
            case 11: return getDeclaredClassName_CTAR12(declIndex);
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
            case 0: return getDeclaredClass_CTAR1(declIndex);
            case 1: return getDeclaredClass_CTAR2(declIndex);
            case 2: return getDeclaredClass_CTAR3(declIndex);
            case 3: return getDeclaredClass_CTAR4(declIndex);
            case 4: return getDeclaredClass_CTAR5(declIndex);
            case 5: return getDeclaredClass_CTAR6(declIndex);
            case 6: return getDeclaredClass_CTAR7(declIndex);
            case 7: return getDeclaredClass_CTAR8(declIndex);
            case 8: return getDeclaredClass_CTAR9(declIndex);
            case 9: return getDeclaredClass_CTAR10(declIndex);
            case 10: return getDeclaredClass_CTAR11(declIndex);
            case 11: return getDeclaredClass_CTAR12(declIndex);
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
            case 0: CTAR1(); break;
            case 1: CTAR2(); break;
            case 2: CTAR3(); break;
            case 3: CTAR4(); break;
            case 4: CTAR5(); break;
            case 5: CTAR6(); break;
            case 6: CTAR7(); break;
            case 7: CTAR8(); break;
            case 8: CTAR9(); break;
            case 9: CTAR10(); break;
            case 10: CTAR11(); break;
            case 11: CTAR12(); break;
        }
    }

    /**
     * Returns the number of rules.
     *
     * @return the number of rules.
     */
    public int getNumberOfRules() {
        return 12;
    }

    /**
     * Returns the identifiers declared in a given rule.
     *
     * @param ruleIndex the index of the rule.
     * @return an array with the identifiers of the rule declarations.
     */
    public String[] getDeclaredIdentifiers(int ruleIndex) {
        switch (ruleIndex) {
            case 0: return getDeclaredIdentifiers_CTAR1();
            case 1: return getDeclaredIdentifiers_CTAR2();
            case 2: return getDeclaredIdentifiers_CTAR3();
            case 3: return getDeclaredIdentifiers_CTAR4();
            case 4: return getDeclaredIdentifiers_CTAR5();
            case 5: return getDeclaredIdentifiers_CTAR6();
            case 6: return getDeclaredIdentifiers_CTAR7();
            case 7: return getDeclaredIdentifiers_CTAR8();
            case 8: return getDeclaredIdentifiers_CTAR9();
            case 9: return getDeclaredIdentifiers_CTAR10();
            case 10: return getDeclaredIdentifiers_CTAR11();
            case 11: return getDeclaredIdentifiers_CTAR12();
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
            case 0: setObject_CTAR1(declIndex, value); break;
            case 1: setObject_CTAR2(declIndex, value); break;
            case 2: setObject_CTAR3(declIndex, value); break;
            case 3: setObject_CTAR4(declIndex, value); break;
            case 4: setObject_CTAR5(declIndex, value); break;
            case 5: setObject_CTAR6(declIndex, value); break;
            case 6: setObject_CTAR7(declIndex, value); break;
            case 7: setObject_CTAR8(declIndex, value); break;
            case 8: setObject_CTAR9(declIndex, value); break;
            case 9: setObject_CTAR10(declIndex, value); break;
            case 10: setObject_CTAR11(declIndex, value); break;
            case 11: setObject_CTAR12(declIndex, value); break;
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
            case 0: return getObject_CTAR1(declIndex);
            case 1: return getObject_CTAR2(declIndex);
            case 2: return getObject_CTAR3(declIndex);
            case 3: return getObject_CTAR4(declIndex);
            case 4: return getObject_CTAR5(declIndex);
            case 5: return getObject_CTAR6(declIndex);
            case 6: return getObject_CTAR7(declIndex);
            case 7: return getObject_CTAR8(declIndex);
            case 8: return getObject_CTAR9(declIndex);
            case 9: return getObject_CTAR10(declIndex);
            case 10: return getObject_CTAR11(declIndex);
            case 11: return getObject_CTAR12(declIndex);
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
            case 0: return getObjects_CTAR1();
            case 1: return getObjects_CTAR2();
            case 2: return getObjects_CTAR3();
            case 3: return getObjects_CTAR4();
            case 4: return getObjects_CTAR5();
            case 5: return getObjects_CTAR6();
            case 6: return getObjects_CTAR7();
            case 7: return getObjects_CTAR8();
            case 8: return getObjects_CTAR9();
            case 9: return getObjects_CTAR10();
            case 10: return getObjects_CTAR11();
            case 11: return getObjects_CTAR12();
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
            case 0: setObjects_CTAR1(objects); break;
            case 1: setObjects_CTAR2(objects); break;
            case 2: setObjects_CTAR3(objects); break;
            case 3: setObjects_CTAR4(objects); break;
            case 4: setObjects_CTAR5(objects); break;
            case 5: setObjects_CTAR6(objects); break;
            case 6: setObjects_CTAR7(objects); break;
            case 7: setObjects_CTAR8(objects); break;
            case 8: setObjects_CTAR9(objects); break;
            case 9: setObjects_CTAR10(objects); break;
            case 10: setObjects_CTAR11(objects); break;
            case 11: setObjects_CTAR12(objects); break;
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
 * @version Jan 30, 2014
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
