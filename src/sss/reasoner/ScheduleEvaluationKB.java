package sss.reasoner;

import sss.scheduler.objects.*;
import sss.scheduler.properties.Availability;
import sss.reasoner.penaltyObjects.*;

/**
 * Rule base used to evaluate a schedule.
 */
  class Jeops_RuleBase_ScheduleEvaluationKB extends jeops.AbstractRuleBase {

	/**
	 * Rules for ClassInSchool
	 */

/* Penalty for class having a free hour. */
  
    /**
     * Identifiers of rule SER1
     */
    private String[] identifiers_SER1 = {
        "schedule",
        "classInSchool",
        "lessonHour"
    };

    /**
     * Returns the identifiers declared in rule SER1
     *
     * @return the identifiers declared in rule SER1
     */
    private String[] getDeclaredIdentifiers_SER1() {
         return identifiers_SER1;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule SER1.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_SER1(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.ClassInSchool";
            case 2: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule SER1.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_SER1(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.ClassInSchool.class;
            case 2: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule SER1.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_SER1(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_ClassInSchool_1 = (sss.scheduler.objects.ClassInSchool) value; break;
            case 2: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule SER1.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_SER1(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Schedule_1;
            case 1: return sss_scheduler_objects_ClassInSchool_1;
            case 2: return sss_scheduler_objects_LessonHour_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule SER1
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_SER1() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_ClassInSchool_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule SER1
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_SER1(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_ClassInSchool_1 = (sss.scheduler.objects.ClassInSchool) objects[1];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[2];
    }

    /**
     * Condition 0 of rule SER1.<p>
     * The original expression was:<br>
     * <code>classInSchool.hasBetweenHourOn(lessonHour)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SER1_cond_0() {
        return (sss_scheduler_objects_ClassInSchool_1.hasBetweenHourOn(sss_scheduler_objects_LessonHour_1));
    }

    /**
     * Checks whether some conditions of rule SER1 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SER1_cond(int index) {
        switch (index) {
            case 0: return SER1_cond_0();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule SER1 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_SER1(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
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
    private boolean checkCondForDeclaration_SER1(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                if (!SER1_cond_0()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule SER1
     */
    private void SER1() {
      sss_scheduler_objects_Schedule_1.addPenaltyObject(new PenaltyClassBetweenHours(sss_scheduler_objects_ClassInSchool_1, sss_scheduler_objects_LessonHour_1), -10000);
      }



/* Penalty for class having a lesson on the 9th hour. */
  
    /**
     * Identifiers of rule SER2
     */
    private String[] identifiers_SER2 = {
        "schedule",
        "classInSchool",
        "lessonHour"
    };

    /**
     * Returns the identifiers declared in rule SER2
     *
     * @return the identifiers declared in rule SER2
     */
    private String[] getDeclaredIdentifiers_SER2() {
         return identifiers_SER2;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule SER2.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_SER2(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.ClassInSchool";
            case 2: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule SER2.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_SER2(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.ClassInSchool.class;
            case 2: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule SER2.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_SER2(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_ClassInSchool_1 = (sss.scheduler.objects.ClassInSchool) value; break;
            case 2: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule SER2.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_SER2(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Schedule_1;
            case 1: return sss_scheduler_objects_ClassInSchool_1;
            case 2: return sss_scheduler_objects_LessonHour_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule SER2
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_SER2() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_ClassInSchool_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule SER2
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_SER2(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_ClassInSchool_1 = (sss.scheduler.objects.ClassInSchool) objects[1];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[2];
    }

    /**
     * Condition 0 of rule SER2.<p>
     * The original expression was:<br>
     * <code>!classInSchool.isAvailable(lessonHour)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SER2_cond_0() {
        return (!sss_scheduler_objects_ClassInSchool_1.isAvailable(sss_scheduler_objects_LessonHour_1));
    }

    /**
     * Condition 1 of rule SER2.<p>
     * The original expression was:<br>
     * <code>lessonHour.getHour() == 9</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SER2_cond_1() {
        return (sss_scheduler_objects_LessonHour_1.getHour() == 9);
    }

    /**
     * Checks whether some conditions of rule SER2 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SER2_cond(int index) {
        switch (index) {
            case 0: return SER2_cond_0();
            case 1: return SER2_cond_1();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule SER2 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_SER2(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                if (!SER2_cond_1()) return false;
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
    private boolean checkCondForDeclaration_SER2(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                if (!SER2_cond_0()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule SER2
     */
    private void SER2() {
      sss_scheduler_objects_Schedule_1.addPenaltyObject(new PenaltyClass9thHour(sss_scheduler_objects_ClassInSchool_1, sss_scheduler_objects_LessonHour_1), -1000);
      }


  
/* Rule to make sure other rules don't fire multiple times. */
  
    /**
     * Identifiers of rule SER3
     */
    private String[] identifiers_SER3 = {
        "classInSchool"
    };

    /**
     * Returns the identifiers declared in rule SER3
     *
     * @return the identifiers declared in rule SER3
     */
    private String[] getDeclaredIdentifiers_SER3() {
         return identifiers_SER3;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule SER3.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_SER3(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.ClassInSchool";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule SER3.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_SER3(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.ClassInSchool.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule SER3.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_SER3(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_ClassInSchool_1 = (sss.scheduler.objects.ClassInSchool) value; break;
        }
    }

    /**
     * Returns an object declared in the rule SER3.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_SER3(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_ClassInSchool_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule SER3
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_SER3() {
        return new Object[] {
                            sss_scheduler_objects_ClassInSchool_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule SER3
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_SER3(Object[] objects) {
        sss_scheduler_objects_ClassInSchool_1 = (sss.scheduler.objects.ClassInSchool) objects[0];
    }

    /**
     * Checks whether some conditions of rule SER3 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SER3_cond(int index) {
        switch (index) {
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule SER3 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_SER3(int declIndex) {
        switch (declIndex) {
            case 0:
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
    private boolean checkCondForDeclaration_SER3(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule SER3
     */
    private void SER3() {
      retract(sss_scheduler_objects_ClassInSchool_1);
      }


  
	/**
	 * Rules for Teacher
	 */
	
/*  Penalty for teacher having to teach on a lesson hour he or she would rather not teach on. */ 
  
    /**
     * Identifiers of rule SER4
     */
    private String[] identifiers_SER4 = {
        "schedule",
        "teacher",
        "lessonHour"
    };

    /**
     * Returns the identifiers declared in rule SER4
     *
     * @return the identifiers declared in rule SER4
     */
    private String[] getDeclaredIdentifiers_SER4() {
         return identifiers_SER4;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule SER4.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_SER4(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.Teacher";
            case 2: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule SER4.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_SER4(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.Teacher.class;
            case 2: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule SER4.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_SER4(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_Teacher_1 = (sss.scheduler.objects.Teacher) value; break;
            case 2: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule SER4.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_SER4(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Schedule_1;
            case 1: return sss_scheduler_objects_Teacher_1;
            case 2: return sss_scheduler_objects_LessonHour_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule SER4
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_SER4() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Teacher_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule SER4
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_SER4(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_Teacher_1 = (sss.scheduler.objects.Teacher) objects[1];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[2];
    }

    /**
     * Condition 0 of rule SER4.<p>
     * The original expression was:<br>
     * <code>teacher.getAvailability(lessonHour) == Availability.RATHER_NOT</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SER4_cond_0() {
        return (sss_scheduler_objects_Teacher_1.getAvailability(sss_scheduler_objects_LessonHour_1) == Availability.RATHER_NOT);
    }

    /**
     * Condition 1 of rule SER4.<p>
     * The original expression was:<br>
     * <code>teacher.isScheduled(lessonHour)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SER4_cond_1() {
        return (sss_scheduler_objects_Teacher_1.isScheduled(sss_scheduler_objects_LessonHour_1));
    }

    /**
     * Checks whether some conditions of rule SER4 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SER4_cond(int index) {
        switch (index) {
            case 0: return SER4_cond_0();
            case 1: return SER4_cond_1();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule SER4 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_SER4(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
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
    private boolean checkCondForDeclaration_SER4(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                if (!SER4_cond_0()) return false;
                if (!SER4_cond_1()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule SER4
     */
    private void SER4() {
	  sss_scheduler_objects_Schedule_1.addPenaltyObject(new PenaltyTeacherRatherNot(sss_scheduler_objects_Teacher_1, sss_scheduler_objects_LessonHour_1), -1000);
      }



/* Penalty for teacher having to walk between classrooms on adjecent hours. */
  
    /**
     * Identifiers of rule SER5
     */
    private String[] identifiers_SER5 = {
        "schedule",
        "lesson1",
        "lesson2",
        "teacher"
    };

    /**
     * Returns the identifiers declared in rule SER5
     *
     * @return the identifiers declared in rule SER5
     */
    private String[] getDeclaredIdentifiers_SER5() {
         return identifiers_SER5;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule SER5.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_SER5(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.Lesson";
            case 2: return "sss.scheduler.objects.Lesson";
            case 3: return "sss.scheduler.objects.Teacher";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule SER5.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_SER5(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.Lesson.class;
            case 2: return sss.scheduler.objects.Lesson.class;
            case 3: return sss.scheduler.objects.Teacher.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule SER5.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_SER5(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 2: this.sss_scheduler_objects_Lesson_2 = (sss.scheduler.objects.Lesson) value; break;
            case 3: this.sss_scheduler_objects_Teacher_1 = (sss.scheduler.objects.Teacher) value; break;
        }
    }

    /**
     * Returns an object declared in the rule SER5.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_SER5(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Schedule_1;
            case 1: return sss_scheduler_objects_Lesson_1;
            case 2: return sss_scheduler_objects_Lesson_2;
            case 3: return sss_scheduler_objects_Teacher_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule SER5
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_SER5() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Lesson_2,
                            sss_scheduler_objects_Teacher_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule SER5
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_SER5(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[1];
        sss_scheduler_objects_Lesson_2 = (sss.scheduler.objects.Lesson) objects[2];
        sss_scheduler_objects_Teacher_1 = (sss.scheduler.objects.Teacher) objects[3];
    }

    /**
     * Condition 0 of rule SER5.<p>
     * The original expression was:<br>
     * <code>lessonHour1.hasNextHour()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SER5_cond_0() {
        return ((sss_scheduler_objects_Lesson_1.getHour()).hasNextHour());
    }

    /**
     * Condition 1 of rule SER5.<p>
     * The original expression was:<br>
     * <code>lessonHour1.getNextHour().equals(lessonHour2)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SER5_cond_1() {
        return ((sss_scheduler_objects_Lesson_1.getHour()).getNextHour().equals((sss_scheduler_objects_Lesson_2.getHour())));
    }

    /**
     * Condition 2 of rule SER5.<p>
     * The original expression was:<br>
     * <code>lesson1.getTeacher().equals(teacher)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SER5_cond_2() {
        return (sss_scheduler_objects_Lesson_1.getTeacher().equals(sss_scheduler_objects_Teacher_1));
    }

    /**
     * Condition 3 of rule SER5.<p>
     * The original expression was:<br>
     * <code>lesson2.getTeacher().equals(teacher)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SER5_cond_3() {
        return (sss_scheduler_objects_Lesson_2.getTeacher().equals(sss_scheduler_objects_Teacher_1));
    }

    /**
     * Condition 4 of rule SER5.<p>
     * The original expression was:<br>
     * <code>!lesson1.getClassroom().equals(lesson2.getClassroom())</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SER5_cond_4() {
        return (!sss_scheduler_objects_Lesson_1.getClassroom().equals(sss_scheduler_objects_Lesson_2.getClassroom()));
    }

    /**
     * Checks whether some conditions of rule SER5 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SER5_cond(int index) {
        switch (index) {
            case 0: return SER5_cond_0();
            case 1: return SER5_cond_1();
            case 2: return SER5_cond_2();
            case 3: return SER5_cond_3();
            case 4: return SER5_cond_4();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule SER5 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_SER5(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!SER5_cond_0()) return false;
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
    private boolean checkCondForDeclaration_SER5(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                if (!SER5_cond_1()) return false;
                if (!SER5_cond_4()) return false;
                return true;
            case 3:
                if (!SER5_cond_2()) return false;
                if (!SER5_cond_3()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule SER5
     */
    private void SER5() {
	  sss_scheduler_objects_Schedule_1.addPenaltyObject(new PenaltyTeacherWalking(sss_scheduler_objects_Teacher_1, sss_scheduler_objects_Lesson_1, sss_scheduler_objects_Lesson_2), -100);
      }


	 
/* Rule to make sure other rules don't fire multiple times. */
  
    /**
     * Identifiers of rule SER6
     */
    private String[] identifiers_SER6 = {
        "teacher"
    };

    /**
     * Returns the identifiers declared in rule SER6
     *
     * @return the identifiers declared in rule SER6
     */
    private String[] getDeclaredIdentifiers_SER6() {
         return identifiers_SER6;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule SER6.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_SER6(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Teacher";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule SER6.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_SER6(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Teacher.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule SER6.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_SER6(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Teacher_1 = (sss.scheduler.objects.Teacher) value; break;
        }
    }

    /**
     * Returns an object declared in the rule SER6.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_SER6(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Teacher_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule SER6
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_SER6() {
        return new Object[] {
                            sss_scheduler_objects_Teacher_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule SER6
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_SER6(Object[] objects) {
        sss_scheduler_objects_Teacher_1 = (sss.scheduler.objects.Teacher) objects[0];
    }

    /**
     * Checks whether some conditions of rule SER6 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SER6_cond(int index) {
        switch (index) {
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule SER6 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_SER6(int declIndex) {
        switch (declIndex) {
            case 0:
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
    private boolean checkCondForDeclaration_SER6(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule SER6
     */
    private void SER6() {
      retract(sss_scheduler_objects_Teacher_1);
      }



    /**
     * The names of the rules in this class file
     */
    private static final String[] File_ruleNames = {
        "SER1",
        "SER2",
        "SER3",
        "SER4",
        "SER5",
        "SER6"
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
        3,
        3,
        1,
        3,
        4,
        1
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
        1,
        2,
        0,
        2,
        5,
        0
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
            case 0: return SER1_cond(condIndex);
            case 1: return SER2_cond(condIndex);
            case 2: return SER3_cond(condIndex);
            case 3: return SER4_cond(condIndex);
            case 4: return SER5_cond(condIndex);
            case 5: return SER6_cond(condIndex);
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
            case 0: return checkConditionsOnlyOf_SER1(declIndex);
            case 1: return checkConditionsOnlyOf_SER2(declIndex);
            case 2: return checkConditionsOnlyOf_SER3(declIndex);
            case 3: return checkConditionsOnlyOf_SER4(declIndex);
            case 4: return checkConditionsOnlyOf_SER5(declIndex);
            case 5: return checkConditionsOnlyOf_SER6(declIndex);
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
            case 0: return checkCondForDeclaration_SER1(declIndex);
            case 1: return checkCondForDeclaration_SER2(declIndex);
            case 2: return checkCondForDeclaration_SER3(declIndex);
            case 3: return checkCondForDeclaration_SER4(declIndex);
            case 4: return checkCondForDeclaration_SER5(declIndex);
            case 5: return checkCondForDeclaration_SER6(declIndex);
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
            case 0: return getDeclaredClassName_SER1(declIndex);
            case 1: return getDeclaredClassName_SER2(declIndex);
            case 2: return getDeclaredClassName_SER3(declIndex);
            case 3: return getDeclaredClassName_SER4(declIndex);
            case 4: return getDeclaredClassName_SER5(declIndex);
            case 5: return getDeclaredClassName_SER6(declIndex);
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
            case 0: return getDeclaredClass_SER1(declIndex);
            case 1: return getDeclaredClass_SER2(declIndex);
            case 2: return getDeclaredClass_SER3(declIndex);
            case 3: return getDeclaredClass_SER4(declIndex);
            case 4: return getDeclaredClass_SER5(declIndex);
            case 5: return getDeclaredClass_SER6(declIndex);
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
            case 0: SER1(); break;
            case 1: SER2(); break;
            case 2: SER3(); break;
            case 3: SER4(); break;
            case 4: SER5(); break;
            case 5: SER6(); break;
        }
    }

    /**
     * Returns the number of rules.
     *
     * @return the number of rules.
     */
    public int getNumberOfRules() {
        return 6;
    }

    /**
     * Returns the identifiers declared in a given rule.
     *
     * @param ruleIndex the index of the rule.
     * @return an array with the identifiers of the rule declarations.
     */
    public String[] getDeclaredIdentifiers(int ruleIndex) {
        switch (ruleIndex) {
            case 0: return getDeclaredIdentifiers_SER1();
            case 1: return getDeclaredIdentifiers_SER2();
            case 2: return getDeclaredIdentifiers_SER3();
            case 3: return getDeclaredIdentifiers_SER4();
            case 4: return getDeclaredIdentifiers_SER5();
            case 5: return getDeclaredIdentifiers_SER6();
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
            case 0: setObject_SER1(declIndex, value); break;
            case 1: setObject_SER2(declIndex, value); break;
            case 2: setObject_SER3(declIndex, value); break;
            case 3: setObject_SER4(declIndex, value); break;
            case 4: setObject_SER5(declIndex, value); break;
            case 5: setObject_SER6(declIndex, value); break;
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
            case 0: return getObject_SER1(declIndex);
            case 1: return getObject_SER2(declIndex);
            case 2: return getObject_SER3(declIndex);
            case 3: return getObject_SER4(declIndex);
            case 4: return getObject_SER5(declIndex);
            case 5: return getObject_SER6(declIndex);
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
            case 0: return getObjects_SER1();
            case 1: return getObjects_SER2();
            case 2: return getObjects_SER3();
            case 3: return getObjects_SER4();
            case 4: return getObjects_SER5();
            case 5: return getObjects_SER6();
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
            case 0: setObjects_SER1(objects); break;
            case 1: setObjects_SER2(objects); break;
            case 2: setObjects_SER3(objects); break;
            case 3: setObjects_SER4(objects); break;
            case 4: setObjects_SER5(objects); break;
            case 5: setObjects_SER6(objects); break;
        }
    }

    /*
     * The variables declared in the rules.
     */
    private sss.scheduler.objects.Schedule sss_scheduler_objects_Schedule_1;
    private sss.scheduler.objects.ClassInSchool sss_scheduler_objects_ClassInSchool_1;
    private sss.scheduler.objects.LessonHour sss_scheduler_objects_LessonHour_1;
    private sss.scheduler.objects.Teacher sss_scheduler_objects_Teacher_1;
    private sss.scheduler.objects.Lesson sss_scheduler_objects_Lesson_1;
    private sss.scheduler.objects.Lesson sss_scheduler_objects_Lesson_2;

    /**
     * Class constructor.
     *
     * @param knowledgeBase the knowledge base that contains this rule base.
     */
    public Jeops_RuleBase_ScheduleEvaluationKB(jeops.AbstractKnowledgeBase knowledgeBase) {
        super(knowledgeBase);
    }

}
/**
 * Knowledge base created by JEOPS from file ScheduleEvaluationKB.rules
 *
 * @version Jan 30, 2014
 */
public class ScheduleEvaluationKB extends jeops.AbstractKnowledgeBase {

    /**
     * Creates a new knowledge base with the specified conflict set with the
     * desired conflict resolution policy.
     *
     * @param conflictSet a conflict set with the desired resolution policy
     */
    public ScheduleEvaluationKB(jeops.conflict.ConflictSet conflictSet) {
        super(conflictSet);
    }

    /**
     * Creates a new knowledge base, using the default conflict resolution
     * policy.
     */
    public ScheduleEvaluationKB() {
        this(new jeops.conflict.DefaultConflictSet());
    }

    /**
     * Factory method used to instantiate the rule base.
     */
    protected jeops.AbstractRuleBase createRuleBase() {
        return new Jeops_RuleBase_ScheduleEvaluationKB(this);
    }

}
