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

  
    /**
     * Identifiers of rule classEvaluationRule1
     */
    private String[] identifiers_classEvaluationRule1 = {
        "schedule",
        "classInSchool"
    };

    /**
     * Returns the identifiers declared in rule classEvaluationRule1
     *
     * @return the identifiers declared in rule classEvaluationRule1
     */
    private String[] getDeclaredIdentifiers_classEvaluationRule1() {
         return identifiers_classEvaluationRule1;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule classEvaluationRule1.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_classEvaluationRule1(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.ClassInSchool";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule classEvaluationRule1.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_classEvaluationRule1(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.ClassInSchool.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule classEvaluationRule1.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_classEvaluationRule1(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_ClassInSchool_1 = (sss.scheduler.objects.ClassInSchool) value; break;
        }
    }

    /**
     * Returns an object declared in the rule classEvaluationRule1.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_classEvaluationRule1(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Schedule_1;
            case 1: return sss_scheduler_objects_ClassInSchool_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule classEvaluationRule1
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_classEvaluationRule1() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_ClassInSchool_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule classEvaluationRule1
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_classEvaluationRule1(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_ClassInSchool_1 = (sss.scheduler.objects.ClassInSchool) objects[1];
    }

    /**
     * Condition 0 of rule classEvaluationRule1.<p>
     * The original expression was:<br>
     * <code>nrOfBetweenHours > 0</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean classEvaluationRule1_cond_0() {
        return ((sss_scheduler_objects_ClassInSchool_1.getNumberOfBetweenHours()) > 0);
    }

    /**
     * Checks whether some conditions of rule classEvaluationRule1 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean classEvaluationRule1_cond(int index) {
        switch (index) {
            case 0: return classEvaluationRule1_cond_0();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule classEvaluationRule1 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_classEvaluationRule1(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!classEvaluationRule1_cond_0()) return false;
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
    private boolean checkCondForDeclaration_classEvaluationRule1(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule classEvaluationRule1
     */
    private void classEvaluationRule1() {
      sss_scheduler_objects_Schedule_1.addToRating((sss_scheduler_objects_ClassInSchool_1.getNumberOfBetweenHours()) * -100000);
      sss_scheduler_objects_Schedule_1.addPenaltyObject(new PenaltyClassBetweenHours(sss_scheduler_objects_ClassInSchool_1));
      // System.out.println("classEvaluationRule1 fired for " + classInSchool.getName() + " with " + (nrOfBetweenHours * 1000) + " penalty points.");
      }



  
    /**
     * Identifiers of rule classEvaluationRule2
     */
    private String[] identifiers_classEvaluationRule2 = {
        "schedule",
        "classInSchool",
        "lessonHour"
    };

    /**
     * Returns the identifiers declared in rule classEvaluationRule2
     *
     * @return the identifiers declared in rule classEvaluationRule2
     */
    private String[] getDeclaredIdentifiers_classEvaluationRule2() {
         return identifiers_classEvaluationRule2;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule classEvaluationRule2.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_classEvaluationRule2(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.ClassInSchool";
            case 2: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule classEvaluationRule2.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_classEvaluationRule2(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.ClassInSchool.class;
            case 2: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule classEvaluationRule2.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_classEvaluationRule2(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_ClassInSchool_1 = (sss.scheduler.objects.ClassInSchool) value; break;
            case 2: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule classEvaluationRule2.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_classEvaluationRule2(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Schedule_1;
            case 1: return sss_scheduler_objects_ClassInSchool_1;
            case 2: return sss_scheduler_objects_LessonHour_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule classEvaluationRule2
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_classEvaluationRule2() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_ClassInSchool_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule classEvaluationRule2
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_classEvaluationRule2(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_ClassInSchool_1 = (sss.scheduler.objects.ClassInSchool) objects[1];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[2];
    }

    /**
     * Condition 0 of rule classEvaluationRule2.<p>
     * The original expression was:<br>
     * <code>!classInSchool.isAvailable(lessonHour)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean classEvaluationRule2_cond_0() {
        return (!sss_scheduler_objects_ClassInSchool_1.isAvailable(sss_scheduler_objects_LessonHour_1));
    }

    /**
     * Condition 1 of rule classEvaluationRule2.<p>
     * The original expression was:<br>
     * <code>lessonHour.getHour() == 9</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean classEvaluationRule2_cond_1() {
        return (sss_scheduler_objects_LessonHour_1.getHour() == 9);
    }

    /**
     * Checks whether some conditions of rule classEvaluationRule2 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean classEvaluationRule2_cond(int index) {
        switch (index) {
            case 0: return classEvaluationRule2_cond_0();
            case 1: return classEvaluationRule2_cond_1();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule classEvaluationRule2 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_classEvaluationRule2(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                if (!classEvaluationRule2_cond_1()) return false;
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
    private boolean checkCondForDeclaration_classEvaluationRule2(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                if (!classEvaluationRule2_cond_0()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule classEvaluationRule2
     */
    private void classEvaluationRule2() {
      sss_scheduler_objects_Schedule_1.addToRating(-1000);
      sss_scheduler_objects_Schedule_1.addPenaltyObject(new PenaltyClass9thHour(sss_scheduler_objects_ClassInSchool_1, sss_scheduler_objects_LessonHour_1));
      // System.out.println("classEvaluationRule2 fired for " + classInSchool.getName() + " on " + lessonHour.getWeekday());
      }


  
  
    /**
     * Identifiers of rule classEvaluationRule3
     */
    private String[] identifiers_classEvaluationRule3 = {
        "classInSchool"
    };

    /**
     * Returns the identifiers declared in rule classEvaluationRule3
     *
     * @return the identifiers declared in rule classEvaluationRule3
     */
    private String[] getDeclaredIdentifiers_classEvaluationRule3() {
         return identifiers_classEvaluationRule3;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule classEvaluationRule3.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_classEvaluationRule3(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.ClassInSchool";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule classEvaluationRule3.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_classEvaluationRule3(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.ClassInSchool.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule classEvaluationRule3.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_classEvaluationRule3(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_ClassInSchool_1 = (sss.scheduler.objects.ClassInSchool) value; break;
        }
    }

    /**
     * Returns an object declared in the rule classEvaluationRule3.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_classEvaluationRule3(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_ClassInSchool_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule classEvaluationRule3
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_classEvaluationRule3() {
        return new Object[] {
                            sss_scheduler_objects_ClassInSchool_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule classEvaluationRule3
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_classEvaluationRule3(Object[] objects) {
        sss_scheduler_objects_ClassInSchool_1 = (sss.scheduler.objects.ClassInSchool) objects[0];
    }

    /**
     * Checks whether some conditions of rule classEvaluationRule3 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean classEvaluationRule3_cond(int index) {
        switch (index) {
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule classEvaluationRule3 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_classEvaluationRule3(int declIndex) {
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
    private boolean checkCondForDeclaration_classEvaluationRule3(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule classEvaluationRule3
     */
    private void classEvaluationRule3() {
      // System.out.println("classEvaluationRule3 fired for " + classInSchool.getName());
      retract(sss_scheduler_objects_ClassInSchool_1);
      }


  
	/**
	 * Rules for Teacher
	 */
	
  // Teacher has been scheduled on an hour he would rather not be scheduled on. 
  
    /**
     * Identifiers of rule teacherEvaluationRule1
     */
    private String[] identifiers_teacherEvaluationRule1 = {
        "schedule",
        "teacher",
        "lessonHour"
    };

    /**
     * Returns the identifiers declared in rule teacherEvaluationRule1
     *
     * @return the identifiers declared in rule teacherEvaluationRule1
     */
    private String[] getDeclaredIdentifiers_teacherEvaluationRule1() {
         return identifiers_teacherEvaluationRule1;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule teacherEvaluationRule1.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_teacherEvaluationRule1(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.Teacher";
            case 2: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule teacherEvaluationRule1.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_teacherEvaluationRule1(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.Teacher.class;
            case 2: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule teacherEvaluationRule1.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_teacherEvaluationRule1(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_Teacher_1 = (sss.scheduler.objects.Teacher) value; break;
            case 2: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule teacherEvaluationRule1.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_teacherEvaluationRule1(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Schedule_1;
            case 1: return sss_scheduler_objects_Teacher_1;
            case 2: return sss_scheduler_objects_LessonHour_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule teacherEvaluationRule1
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_teacherEvaluationRule1() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Teacher_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule teacherEvaluationRule1
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_teacherEvaluationRule1(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_Teacher_1 = (sss.scheduler.objects.Teacher) objects[1];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[2];
    }

    /**
     * Condition 0 of rule teacherEvaluationRule1.<p>
     * The original expression was:<br>
     * <code>teacher.getAvailability(lessonHour) == Availability.RATHER_NOT</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean teacherEvaluationRule1_cond_0() {
        return (sss_scheduler_objects_Teacher_1.getAvailability(sss_scheduler_objects_LessonHour_1) == Availability.RATHER_NOT);
    }

    /**
     * Condition 1 of rule teacherEvaluationRule1.<p>
     * The original expression was:<br>
     * <code>teacher.isScheduled(lessonHour)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean teacherEvaluationRule1_cond_1() {
        return (sss_scheduler_objects_Teacher_1.isScheduled(sss_scheduler_objects_LessonHour_1));
    }

    /**
     * Checks whether some conditions of rule teacherEvaluationRule1 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean teacherEvaluationRule1_cond(int index) {
        switch (index) {
            case 0: return teacherEvaluationRule1_cond_0();
            case 1: return teacherEvaluationRule1_cond_1();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule teacherEvaluationRule1 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_teacherEvaluationRule1(int declIndex) {
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
    private boolean checkCondForDeclaration_teacherEvaluationRule1(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                if (!teacherEvaluationRule1_cond_0()) return false;
                if (!teacherEvaluationRule1_cond_1()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule teacherEvaluationRule1
     */
    private void teacherEvaluationRule1() {
      // System.out.println("teacherEvaluationRule1 fired for " + teacher.getName() + " on " + lessonHour.getWeekday() + " at " + lessonHour.getHour());
	  sss_scheduler_objects_Schedule_1.addPenaltyObject(new PenaltyTeacherRatherNot(sss_scheduler_objects_Teacher_1, sss_scheduler_objects_LessonHour_1));
      sss_scheduler_objects_Schedule_1.addToRating(-1000);
      }



  // Teacher has to walk in between hours.
  
    /**
     * Identifiers of rule teacherEvaluationRule2
     */
    private String[] identifiers_teacherEvaluationRule2 = {
        "schedule",
        "lesson1",
        "lesson2",
        "teacher"
    };

    /**
     * Returns the identifiers declared in rule teacherEvaluationRule2
     *
     * @return the identifiers declared in rule teacherEvaluationRule2
     */
    private String[] getDeclaredIdentifiers_teacherEvaluationRule2() {
         return identifiers_teacherEvaluationRule2;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule teacherEvaluationRule2.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_teacherEvaluationRule2(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.Lesson";
            case 2: return "sss.scheduler.objects.Lesson";
            case 3: return "sss.scheduler.objects.Teacher";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule teacherEvaluationRule2.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_teacherEvaluationRule2(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.Lesson.class;
            case 2: return sss.scheduler.objects.Lesson.class;
            case 3: return sss.scheduler.objects.Teacher.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule teacherEvaluationRule2.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_teacherEvaluationRule2(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 2: this.sss_scheduler_objects_Lesson_2 = (sss.scheduler.objects.Lesson) value; break;
            case 3: this.sss_scheduler_objects_Teacher_1 = (sss.scheduler.objects.Teacher) value; break;
        }
    }

    /**
     * Returns an object declared in the rule teacherEvaluationRule2.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_teacherEvaluationRule2(int index) {
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
     * of rule teacherEvaluationRule2
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_teacherEvaluationRule2() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Lesson_2,
                            sss_scheduler_objects_Teacher_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule teacherEvaluationRule2
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_teacherEvaluationRule2(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[1];
        sss_scheduler_objects_Lesson_2 = (sss.scheduler.objects.Lesson) objects[2];
        sss_scheduler_objects_Teacher_1 = (sss.scheduler.objects.Teacher) objects[3];
    }

    /**
     * Condition 0 of rule teacherEvaluationRule2.<p>
     * The original expression was:<br>
     * <code>lessonHour1.hasNextHour()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean teacherEvaluationRule2_cond_0() {
        return ((sss_scheduler_objects_Lesson_1.getHour()).hasNextHour());
    }

    /**
     * Condition 1 of rule teacherEvaluationRule2.<p>
     * The original expression was:<br>
     * <code>lessonHour1.getNextHour().equals(lessonHour2)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean teacherEvaluationRule2_cond_1() {
        return ((sss_scheduler_objects_Lesson_1.getHour()).getNextHour().equals((sss_scheduler_objects_Lesson_2.getHour())));
    }

    /**
     * Condition 2 of rule teacherEvaluationRule2.<p>
     * The original expression was:<br>
     * <code>lesson1.getTeacher().equals(teacher)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean teacherEvaluationRule2_cond_2() {
        return (sss_scheduler_objects_Lesson_1.getTeacher().equals(sss_scheduler_objects_Teacher_1));
    }

    /**
     * Condition 3 of rule teacherEvaluationRule2.<p>
     * The original expression was:<br>
     * <code>lesson2.getTeacher().equals(teacher)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean teacherEvaluationRule2_cond_3() {
        return (sss_scheduler_objects_Lesson_2.getTeacher().equals(sss_scheduler_objects_Teacher_1));
    }

    /**
     * Condition 4 of rule teacherEvaluationRule2.<p>
     * The original expression was:<br>
     * <code>!lesson1.getClassroom().equals(lesson2.getClassroom())</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean teacherEvaluationRule2_cond_4() {
        return (!sss_scheduler_objects_Lesson_1.getClassroom().equals(sss_scheduler_objects_Lesson_2.getClassroom()));
    }

    /**
     * Checks whether some conditions of rule teacherEvaluationRule2 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean teacherEvaluationRule2_cond(int index) {
        switch (index) {
            case 0: return teacherEvaluationRule2_cond_0();
            case 1: return teacherEvaluationRule2_cond_1();
            case 2: return teacherEvaluationRule2_cond_2();
            case 3: return teacherEvaluationRule2_cond_3();
            case 4: return teacherEvaluationRule2_cond_4();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule teacherEvaluationRule2 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_teacherEvaluationRule2(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!teacherEvaluationRule2_cond_0()) return false;
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
    private boolean checkCondForDeclaration_teacherEvaluationRule2(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                if (!teacherEvaluationRule2_cond_1()) return false;
                if (!teacherEvaluationRule2_cond_4()) return false;
                return true;
            case 3:
                if (!teacherEvaluationRule2_cond_2()) return false;
                if (!teacherEvaluationRule2_cond_3()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule teacherEvaluationRule2
     */
    private void teacherEvaluationRule2() {
      // System.out.println("teacherEvaluationRule2 fired for " + teacher.getName());
	  sss_scheduler_objects_Schedule_1.addPenaltyObject(new PenaltyTeacherWalking(sss_scheduler_objects_Teacher_1, sss_scheduler_objects_Lesson_1, sss_scheduler_objects_Lesson_2));
      sss_scheduler_objects_Schedule_1.addToRating(-100);
      }


	 
  
    /**
     * Identifiers of rule teacherEvaluationRule3
     */
    private String[] identifiers_teacherEvaluationRule3 = {
        "teacher"
    };

    /**
     * Returns the identifiers declared in rule teacherEvaluationRule3
     *
     * @return the identifiers declared in rule teacherEvaluationRule3
     */
    private String[] getDeclaredIdentifiers_teacherEvaluationRule3() {
         return identifiers_teacherEvaluationRule3;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule teacherEvaluationRule3.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_teacherEvaluationRule3(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Teacher";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule teacherEvaluationRule3.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_teacherEvaluationRule3(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Teacher.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule teacherEvaluationRule3.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_teacherEvaluationRule3(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Teacher_1 = (sss.scheduler.objects.Teacher) value; break;
        }
    }

    /**
     * Returns an object declared in the rule teacherEvaluationRule3.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_teacherEvaluationRule3(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Teacher_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule teacherEvaluationRule3
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_teacherEvaluationRule3() {
        return new Object[] {
                            sss_scheduler_objects_Teacher_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule teacherEvaluationRule3
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_teacherEvaluationRule3(Object[] objects) {
        sss_scheduler_objects_Teacher_1 = (sss.scheduler.objects.Teacher) objects[0];
    }

    /**
     * Checks whether some conditions of rule teacherEvaluationRule3 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean teacherEvaluationRule3_cond(int index) {
        switch (index) {
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule teacherEvaluationRule3 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_teacherEvaluationRule3(int declIndex) {
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
    private boolean checkCondForDeclaration_teacherEvaluationRule3(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule teacherEvaluationRule3
     */
    private void teacherEvaluationRule3() {
      // System.out.println("teacherEvaluationRule3 fired for " + teacher.getName());
      retract(sss_scheduler_objects_Teacher_1);
      }



    /**
     * The names of the rules in this class file
     */
    private static final String[] File_ruleNames = {
        "classEvaluationRule1",
        "classEvaluationRule2",
        "classEvaluationRule3",
        "teacherEvaluationRule1",
        "teacherEvaluationRule2",
        "teacherEvaluationRule3"
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
        2,
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
            case 0: return classEvaluationRule1_cond(condIndex);
            case 1: return classEvaluationRule2_cond(condIndex);
            case 2: return classEvaluationRule3_cond(condIndex);
            case 3: return teacherEvaluationRule1_cond(condIndex);
            case 4: return teacherEvaluationRule2_cond(condIndex);
            case 5: return teacherEvaluationRule3_cond(condIndex);
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
            case 0: return checkConditionsOnlyOf_classEvaluationRule1(declIndex);
            case 1: return checkConditionsOnlyOf_classEvaluationRule2(declIndex);
            case 2: return checkConditionsOnlyOf_classEvaluationRule3(declIndex);
            case 3: return checkConditionsOnlyOf_teacherEvaluationRule1(declIndex);
            case 4: return checkConditionsOnlyOf_teacherEvaluationRule2(declIndex);
            case 5: return checkConditionsOnlyOf_teacherEvaluationRule3(declIndex);
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
            case 0: return checkCondForDeclaration_classEvaluationRule1(declIndex);
            case 1: return checkCondForDeclaration_classEvaluationRule2(declIndex);
            case 2: return checkCondForDeclaration_classEvaluationRule3(declIndex);
            case 3: return checkCondForDeclaration_teacherEvaluationRule1(declIndex);
            case 4: return checkCondForDeclaration_teacherEvaluationRule2(declIndex);
            case 5: return checkCondForDeclaration_teacherEvaluationRule3(declIndex);
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
            case 0: return getDeclaredClassName_classEvaluationRule1(declIndex);
            case 1: return getDeclaredClassName_classEvaluationRule2(declIndex);
            case 2: return getDeclaredClassName_classEvaluationRule3(declIndex);
            case 3: return getDeclaredClassName_teacherEvaluationRule1(declIndex);
            case 4: return getDeclaredClassName_teacherEvaluationRule2(declIndex);
            case 5: return getDeclaredClassName_teacherEvaluationRule3(declIndex);
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
            case 0: return getDeclaredClass_classEvaluationRule1(declIndex);
            case 1: return getDeclaredClass_classEvaluationRule2(declIndex);
            case 2: return getDeclaredClass_classEvaluationRule3(declIndex);
            case 3: return getDeclaredClass_teacherEvaluationRule1(declIndex);
            case 4: return getDeclaredClass_teacherEvaluationRule2(declIndex);
            case 5: return getDeclaredClass_teacherEvaluationRule3(declIndex);
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
            case 0: classEvaluationRule1(); break;
            case 1: classEvaluationRule2(); break;
            case 2: classEvaluationRule3(); break;
            case 3: teacherEvaluationRule1(); break;
            case 4: teacherEvaluationRule2(); break;
            case 5: teacherEvaluationRule3(); break;
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
            case 0: return getDeclaredIdentifiers_classEvaluationRule1();
            case 1: return getDeclaredIdentifiers_classEvaluationRule2();
            case 2: return getDeclaredIdentifiers_classEvaluationRule3();
            case 3: return getDeclaredIdentifiers_teacherEvaluationRule1();
            case 4: return getDeclaredIdentifiers_teacherEvaluationRule2();
            case 5: return getDeclaredIdentifiers_teacherEvaluationRule3();
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
            case 0: setObject_classEvaluationRule1(declIndex, value); break;
            case 1: setObject_classEvaluationRule2(declIndex, value); break;
            case 2: setObject_classEvaluationRule3(declIndex, value); break;
            case 3: setObject_teacherEvaluationRule1(declIndex, value); break;
            case 4: setObject_teacherEvaluationRule2(declIndex, value); break;
            case 5: setObject_teacherEvaluationRule3(declIndex, value); break;
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
            case 0: return getObject_classEvaluationRule1(declIndex);
            case 1: return getObject_classEvaluationRule2(declIndex);
            case 2: return getObject_classEvaluationRule3(declIndex);
            case 3: return getObject_teacherEvaluationRule1(declIndex);
            case 4: return getObject_teacherEvaluationRule2(declIndex);
            case 5: return getObject_teacherEvaluationRule3(declIndex);
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
            case 0: return getObjects_classEvaluationRule1();
            case 1: return getObjects_classEvaluationRule2();
            case 2: return getObjects_classEvaluationRule3();
            case 3: return getObjects_teacherEvaluationRule1();
            case 4: return getObjects_teacherEvaluationRule2();
            case 5: return getObjects_teacherEvaluationRule3();
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
            case 0: setObjects_classEvaluationRule1(objects); break;
            case 1: setObjects_classEvaluationRule2(objects); break;
            case 2: setObjects_classEvaluationRule3(objects); break;
            case 3: setObjects_teacherEvaluationRule1(objects); break;
            case 4: setObjects_teacherEvaluationRule2(objects); break;
            case 5: setObjects_teacherEvaluationRule3(objects); break;
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
 * @version Jan 29, 2014
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
