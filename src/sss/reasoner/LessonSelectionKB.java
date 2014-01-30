package sss.reasoner;

import sss.scheduler.objects.Lesson;
import sss.scheduler.objects.Schedule;

/**
 * Rule base used to select lessons.
 */
  class Jeops_RuleBase_LessonSelectionKB extends jeops.AbstractRuleBase {

  /* Select lesson with lowest availability count */
  
    /**
     * Identifiers of rule LSR1
     */
    private String[] identifiers_LSR1 = {
        "lesson",
        "schedule"
    };

    /**
     * Returns the identifiers declared in rule LSR1
     *
     * @return the identifiers declared in rule LSR1
     */
    private String[] getDeclaredIdentifiers_LSR1() {
         return identifiers_LSR1;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule LSR1.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_LSR1(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Lesson";
            case 1: return "sss.scheduler.objects.Schedule";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule LSR1.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_LSR1(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Lesson.class;
            case 1: return sss.scheduler.objects.Schedule.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule LSR1.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_LSR1(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 1: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
        }
    }

    /**
     * Returns an object declared in the rule LSR1.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_LSR1(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Lesson_1;
            case 1: return sss_scheduler_objects_Schedule_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule LSR1
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_LSR1() {
        return new Object[] {
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Schedule_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule LSR1
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_LSR1(Object[] objects) {
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[0];
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[1];
    }

    /**
     * Condition 0 of rule LSR1.<p>
     * The original expression was:<br>
     * <code>schedule.schedulingSetIsEmpty()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR1_cond_0() {
        return (sss_scheduler_objects_Schedule_1.schedulingSetIsEmpty());
    }

    /**
     * Condition 1 of rule LSR1.<p>
     * The original expression was:<br>
     * <code>schedule.containsUnallocatedLesson(lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR1_cond_1() {
        return (sss_scheduler_objects_Schedule_1.containsUnallocatedLesson(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 2 of rule LSR1.<p>
     * The original expression was:<br>
     * <code>schedule.singleLowestAvailabilityCount()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR1_cond_2() {
        return (sss_scheduler_objects_Schedule_1.singleLowestAvailabilityCount());
    }

    /**
     * Condition 3 of rule LSR1.<p>
     * The original expression was:<br>
     * <code>!lesson.isAllocatedToTimeslot()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR1_cond_3() {
        return (!sss_scheduler_objects_Lesson_1.isAllocatedToTimeslot());
    }

    /**
     * Condition 4 of rule LSR1.<p>
     * The original expression was:<br>
     * <code>lesson.getAvailabilityCount() == lowestAvailabilityCount</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR1_cond_4() {
        return (sss_scheduler_objects_Lesson_1.getAvailabilityCount() == (sss_scheduler_objects_Schedule_1.lowestAvailabilityCount()));
    }

    /**
     * Checks whether some conditions of rule LSR1 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR1_cond(int index) {
        switch (index) {
            case 0: return LSR1_cond_0();
            case 1: return LSR1_cond_1();
            case 2: return LSR1_cond_2();
            case 3: return LSR1_cond_3();
            case 4: return LSR1_cond_4();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule LSR1 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_LSR1(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!LSR1_cond_3()) return false;
                return true;
            case 1:
                if (!LSR1_cond_0()) return false;
                if (!LSR1_cond_2()) return false;
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
    private boolean checkCondForDeclaration_LSR1(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!LSR1_cond_1()) return false;
                if (!LSR1_cond_4()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule LSR1
     */
    private void LSR1() {
	  sss_scheduler_objects_Schedule_1.addToSchedulingSet(sss_scheduler_objects_Lesson_1);
      modified(sss_scheduler_objects_Schedule_1);
      retract(sss_scheduler_objects_Lesson_1);
      }



  /* If multiple lessons have lowest count, select lesson for course that is hard to allocate */
  
    /**
     * Identifiers of rule LSR2
     */
    private String[] identifiers_LSR2 = {
        "lesson",
        "schedule"
    };

    /**
     * Returns the identifiers declared in rule LSR2
     *
     * @return the identifiers declared in rule LSR2
     */
    private String[] getDeclaredIdentifiers_LSR2() {
         return identifiers_LSR2;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule LSR2.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_LSR2(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Lesson";
            case 1: return "sss.scheduler.objects.Schedule";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule LSR2.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_LSR2(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Lesson.class;
            case 1: return sss.scheduler.objects.Schedule.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule LSR2.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_LSR2(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 1: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
        }
    }

    /**
     * Returns an object declared in the rule LSR2.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_LSR2(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Lesson_1;
            case 1: return sss_scheduler_objects_Schedule_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule LSR2
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_LSR2() {
        return new Object[] {
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Schedule_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule LSR2
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_LSR2(Object[] objects) {
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[0];
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[1];
    }

    /**
     * Condition 0 of rule LSR2.<p>
     * The original expression was:<br>
     * <code>schedule.schedulingSetIsEmpty()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR2_cond_0() {
        return (sss_scheduler_objects_Schedule_1.schedulingSetIsEmpty());
    }

    /**
     * Condition 1 of rule LSR2.<p>
     * The original expression was:<br>
     * <code>schedule.containsUnallocatedLesson(lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR2_cond_1() {
        return (sss_scheduler_objects_Schedule_1.containsUnallocatedLesson(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 2 of rule LSR2.<p>
     * The original expression was:<br>
     * <code>!schedule.singleLowestAvailabilityCount()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR2_cond_2() {
        return (!sss_scheduler_objects_Schedule_1.singleLowestAvailabilityCount());
    }

    /**
     * Condition 3 of rule LSR2.<p>
     * The original expression was:<br>
     * <code>!lesson.isAllocatedToTimeslot()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR2_cond_3() {
        return (!sss_scheduler_objects_Lesson_1.isAllocatedToTimeslot());
    }

    /**
     * Condition 4 of rule LSR2.<p>
     * The original expression was:<br>
     * <code>lesson.getAvailabilityCount() == lowestAvailabilityCount</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR2_cond_4() {
        return (sss_scheduler_objects_Lesson_1.getAvailabilityCount() == (sss_scheduler_objects_Schedule_1.lowestAvailabilityCount()));
    }

    /**
     * Condition 5 of rule LSR2.<p>
     * The original expression was:<br>
     * <code>lesson.getSubject().getCode().equals("LO")</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR2_cond_5() {
        return (sss_scheduler_objects_Lesson_1.getSubject().getCode().equals("LO"));
    }

    /**
     * Checks whether some conditions of rule LSR2 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR2_cond(int index) {
        switch (index) {
            case 0: return LSR2_cond_0();
            case 1: return LSR2_cond_1();
            case 2: return LSR2_cond_2();
            case 3: return LSR2_cond_3();
            case 4: return LSR2_cond_4();
            case 5: return LSR2_cond_5();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule LSR2 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_LSR2(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!LSR2_cond_3()) return false;
                if (!LSR2_cond_5()) return false;
                return true;
            case 1:
                if (!LSR2_cond_0()) return false;
                if (!LSR2_cond_2()) return false;
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
    private boolean checkCondForDeclaration_LSR2(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!LSR2_cond_1()) return false;
                if (!LSR2_cond_4()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule LSR2
     */
    private void LSR2() {
	  sss_scheduler_objects_Schedule_1.addToSchedulingSet(sss_scheduler_objects_Lesson_1);
      modified(sss_scheduler_objects_Schedule_1);
      retract(sss_scheduler_objects_Lesson_1);
      }



  /* If multiple lessons have lowest count, select lesson for course that is hard to allocate */
  
    /**
     * Identifiers of rule LSR3
     */
    private String[] identifiers_LSR3 = {
        "lesson",
        "schedule"
    };

    /**
     * Returns the identifiers declared in rule LSR3
     *
     * @return the identifiers declared in rule LSR3
     */
    private String[] getDeclaredIdentifiers_LSR3() {
         return identifiers_LSR3;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule LSR3.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_LSR3(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Lesson";
            case 1: return "sss.scheduler.objects.Schedule";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule LSR3.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_LSR3(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Lesson.class;
            case 1: return sss.scheduler.objects.Schedule.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule LSR3.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_LSR3(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 1: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
        }
    }

    /**
     * Returns an object declared in the rule LSR3.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_LSR3(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Lesson_1;
            case 1: return sss_scheduler_objects_Schedule_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule LSR3
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_LSR3() {
        return new Object[] {
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Schedule_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule LSR3
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_LSR3(Object[] objects) {
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[0];
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[1];
    }

    /**
     * Condition 0 of rule LSR3.<p>
     * The original expression was:<br>
     * <code>schedule.schedulingSetIsEmpty()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR3_cond_0() {
        return (sss_scheduler_objects_Schedule_1.schedulingSetIsEmpty());
    }

    /**
     * Condition 1 of rule LSR3.<p>
     * The original expression was:<br>
     * <code>schedule.containsUnallocatedLesson(lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR3_cond_1() {
        return (sss_scheduler_objects_Schedule_1.containsUnallocatedLesson(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 2 of rule LSR3.<p>
     * The original expression was:<br>
     * <code>!schedule.singleLowestAvailabilityCount()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR3_cond_2() {
        return (!sss_scheduler_objects_Schedule_1.singleLowestAvailabilityCount());
    }

    /**
     * Condition 3 of rule LSR3.<p>
     * The original expression was:<br>
     * <code>!lesson.isAllocatedToTimeslot()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR3_cond_3() {
        return (!sss_scheduler_objects_Lesson_1.isAllocatedToTimeslot());
    }

    /**
     * Condition 4 of rule LSR3.<p>
     * The original expression was:<br>
     * <code>lesson.getAvailabilityCount() == lowestAvailabilityCount</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR3_cond_4() {
        return (sss_scheduler_objects_Lesson_1.getAvailabilityCount() == (sss_scheduler_objects_Schedule_1.lowestAvailabilityCount()));
    }

    /**
     * Condition 5 of rule LSR3.<p>
     * The original expression was:<br>
     * <code>lesson.getSubject().getCode().equals("HV")</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR3_cond_5() {
        return (sss_scheduler_objects_Lesson_1.getSubject().getCode().equals("HV"));
    }

    /**
     * Checks whether some conditions of rule LSR3 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR3_cond(int index) {
        switch (index) {
            case 0: return LSR3_cond_0();
            case 1: return LSR3_cond_1();
            case 2: return LSR3_cond_2();
            case 3: return LSR3_cond_3();
            case 4: return LSR3_cond_4();
            case 5: return LSR3_cond_5();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule LSR3 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_LSR3(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!LSR3_cond_3()) return false;
                if (!LSR3_cond_5()) return false;
                return true;
            case 1:
                if (!LSR3_cond_0()) return false;
                if (!LSR3_cond_2()) return false;
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
    private boolean checkCondForDeclaration_LSR3(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!LSR3_cond_1()) return false;
                if (!LSR3_cond_4()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule LSR3
     */
    private void LSR3() {
	  sss_scheduler_objects_Schedule_1.addToSchedulingSet(sss_scheduler_objects_Lesson_1);
      modified(sss_scheduler_objects_Schedule_1);
      retract(sss_scheduler_objects_Lesson_1);
      }



  /* If multiple lessons have lowest count, select lesson for course that is hard to allocate */
  
    /**
     * Identifiers of rule LSR4
     */
    private String[] identifiers_LSR4 = {
        "lesson",
        "schedule"
    };

    /**
     * Returns the identifiers declared in rule LSR4
     *
     * @return the identifiers declared in rule LSR4
     */
    private String[] getDeclaredIdentifiers_LSR4() {
         return identifiers_LSR4;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule LSR4.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_LSR4(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Lesson";
            case 1: return "sss.scheduler.objects.Schedule";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule LSR4.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_LSR4(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Lesson.class;
            case 1: return sss.scheduler.objects.Schedule.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule LSR4.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_LSR4(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 1: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
        }
    }

    /**
     * Returns an object declared in the rule LSR4.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_LSR4(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Lesson_1;
            case 1: return sss_scheduler_objects_Schedule_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule LSR4
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_LSR4() {
        return new Object[] {
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Schedule_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule LSR4
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_LSR4(Object[] objects) {
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[0];
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[1];
    }

    /**
     * Condition 0 of rule LSR4.<p>
     * The original expression was:<br>
     * <code>schedule.schedulingSetIsEmpty()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR4_cond_0() {
        return (sss_scheduler_objects_Schedule_1.schedulingSetIsEmpty());
    }

    /**
     * Condition 1 of rule LSR4.<p>
     * The original expression was:<br>
     * <code>schedule.containsUnallocatedLesson(lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR4_cond_1() {
        return (sss_scheduler_objects_Schedule_1.containsUnallocatedLesson(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 2 of rule LSR4.<p>
     * The original expression was:<br>
     * <code>!schedule.singleLowestAvailabilityCount()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR4_cond_2() {
        return (!sss_scheduler_objects_Schedule_1.singleLowestAvailabilityCount());
    }

    /**
     * Condition 3 of rule LSR4.<p>
     * The original expression was:<br>
     * <code>!lesson.isAllocatedToTimeslot()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR4_cond_3() {
        return (!sss_scheduler_objects_Lesson_1.isAllocatedToTimeslot());
    }

    /**
     * Condition 4 of rule LSR4.<p>
     * The original expression was:<br>
     * <code>lesson.getAvailabilityCount() == lowestAvailabilityCount</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR4_cond_4() {
        return (sss_scheduler_objects_Lesson_1.getAvailabilityCount() == (sss_scheduler_objects_Schedule_1.lowestAvailabilityCount()));
    }

    /**
     * Condition 5 of rule LSR4.<p>
     * The original expression was:<br>
     * <code>lesson.getSubject().getCode().equals("IN")</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR4_cond_5() {
        return (sss_scheduler_objects_Lesson_1.getSubject().getCode().equals("IN"));
    }

    /**
     * Checks whether some conditions of rule LSR4 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR4_cond(int index) {
        switch (index) {
            case 0: return LSR4_cond_0();
            case 1: return LSR4_cond_1();
            case 2: return LSR4_cond_2();
            case 3: return LSR4_cond_3();
            case 4: return LSR4_cond_4();
            case 5: return LSR4_cond_5();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule LSR4 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_LSR4(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!LSR4_cond_3()) return false;
                if (!LSR4_cond_5()) return false;
                return true;
            case 1:
                if (!LSR4_cond_0()) return false;
                if (!LSR4_cond_2()) return false;
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
    private boolean checkCondForDeclaration_LSR4(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!LSR4_cond_1()) return false;
                if (!LSR4_cond_4()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule LSR4
     */
    private void LSR4() {
	  sss_scheduler_objects_Schedule_1.addToSchedulingSet(sss_scheduler_objects_Lesson_1);
      modified(sss_scheduler_objects_Schedule_1);
      retract(sss_scheduler_objects_Lesson_1);
      }



  /* If multiple lessons have lowest count and no special course is left, select any course. */
  
    /**
     * Identifiers of rule LSR5
     */
    private String[] identifiers_LSR5 = {
        "lesson",
        "schedule"
    };

    /**
     * Returns the identifiers declared in rule LSR5
     *
     * @return the identifiers declared in rule LSR5
     */
    private String[] getDeclaredIdentifiers_LSR5() {
         return identifiers_LSR5;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule LSR5.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_LSR5(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Lesson";
            case 1: return "sss.scheduler.objects.Schedule";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule LSR5.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_LSR5(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Lesson.class;
            case 1: return sss.scheduler.objects.Schedule.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule LSR5.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_LSR5(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 1: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
        }
    }

    /**
     * Returns an object declared in the rule LSR5.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_LSR5(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Lesson_1;
            case 1: return sss_scheduler_objects_Schedule_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule LSR5
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_LSR5() {
        return new Object[] {
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Schedule_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule LSR5
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_LSR5(Object[] objects) {
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[0];
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[1];
    }

    /**
     * Condition 0 of rule LSR5.<p>
     * The original expression was:<br>
     * <code>schedule.schedulingSetIsEmpty()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR5_cond_0() {
        return (sss_scheduler_objects_Schedule_1.schedulingSetIsEmpty());
    }

    /**
     * Condition 1 of rule LSR5.<p>
     * The original expression was:<br>
     * <code>schedule.containsUnallocatedLesson(lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR5_cond_1() {
        return (sss_scheduler_objects_Schedule_1.containsUnallocatedLesson(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 2 of rule LSR5.<p>
     * The original expression was:<br>
     * <code>!schedule.singleLowestAvailabilityCount()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR5_cond_2() {
        return (!sss_scheduler_objects_Schedule_1.singleLowestAvailabilityCount());
    }

    /**
     * Condition 3 of rule LSR5.<p>
     * The original expression was:<br>
     * <code>!lesson.isAllocatedToTimeslot()</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR5_cond_3() {
        return (!sss_scheduler_objects_Lesson_1.isAllocatedToTimeslot());
    }

    /**
     * Condition 4 of rule LSR5.<p>
     * The original expression was:<br>
     * <code>lesson.getAvailabilityCount() == lowestAvailabilityCount</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR5_cond_4() {
        return (sss_scheduler_objects_Lesson_1.getAvailabilityCount() == (sss_scheduler_objects_Schedule_1.lowestAvailabilityCount()));
    }

    /**
     * Checks whether some conditions of rule LSR5 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean LSR5_cond(int index) {
        switch (index) {
            case 0: return LSR5_cond_0();
            case 1: return LSR5_cond_1();
            case 2: return LSR5_cond_2();
            case 3: return LSR5_cond_3();
            case 4: return LSR5_cond_4();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule LSR5 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_LSR5(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!LSR5_cond_3()) return false;
                return true;
            case 1:
                if (!LSR5_cond_0()) return false;
                if (!LSR5_cond_2()) return false;
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
    private boolean checkCondForDeclaration_LSR5(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!LSR5_cond_1()) return false;
                if (!LSR5_cond_4()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule LSR5
     */
    private void LSR5() {
	  sss_scheduler_objects_Schedule_1.addToSchedulingSet(sss_scheduler_objects_Lesson_1);
      modified(sss_scheduler_objects_Schedule_1);
      retract(sss_scheduler_objects_Lesson_1);
      }




    /**
     * The names of the rules in this class file
     */
    private static final String[] File_ruleNames = {
        "LSR1",
        "LSR2",
        "LSR3",
        "LSR4",
        "LSR5"
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
        2,
        2,
        2,
        2
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
        5,
        6,
        6,
        6,
        5
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
            case 0: return LSR1_cond(condIndex);
            case 1: return LSR2_cond(condIndex);
            case 2: return LSR3_cond(condIndex);
            case 3: return LSR4_cond(condIndex);
            case 4: return LSR5_cond(condIndex);
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
            case 0: return checkConditionsOnlyOf_LSR1(declIndex);
            case 1: return checkConditionsOnlyOf_LSR2(declIndex);
            case 2: return checkConditionsOnlyOf_LSR3(declIndex);
            case 3: return checkConditionsOnlyOf_LSR4(declIndex);
            case 4: return checkConditionsOnlyOf_LSR5(declIndex);
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
            case 0: return checkCondForDeclaration_LSR1(declIndex);
            case 1: return checkCondForDeclaration_LSR2(declIndex);
            case 2: return checkCondForDeclaration_LSR3(declIndex);
            case 3: return checkCondForDeclaration_LSR4(declIndex);
            case 4: return checkCondForDeclaration_LSR5(declIndex);
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
            case 0: return getDeclaredClassName_LSR1(declIndex);
            case 1: return getDeclaredClassName_LSR2(declIndex);
            case 2: return getDeclaredClassName_LSR3(declIndex);
            case 3: return getDeclaredClassName_LSR4(declIndex);
            case 4: return getDeclaredClassName_LSR5(declIndex);
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
            case 0: return getDeclaredClass_LSR1(declIndex);
            case 1: return getDeclaredClass_LSR2(declIndex);
            case 2: return getDeclaredClass_LSR3(declIndex);
            case 3: return getDeclaredClass_LSR4(declIndex);
            case 4: return getDeclaredClass_LSR5(declIndex);
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
            case 0: LSR1(); break;
            case 1: LSR2(); break;
            case 2: LSR3(); break;
            case 3: LSR4(); break;
            case 4: LSR5(); break;
        }
    }

    /**
     * Returns the number of rules.
     *
     * @return the number of rules.
     */
    public int getNumberOfRules() {
        return 5;
    }

    /**
     * Returns the identifiers declared in a given rule.
     *
     * @param ruleIndex the index of the rule.
     * @return an array with the identifiers of the rule declarations.
     */
    public String[] getDeclaredIdentifiers(int ruleIndex) {
        switch (ruleIndex) {
            case 0: return getDeclaredIdentifiers_LSR1();
            case 1: return getDeclaredIdentifiers_LSR2();
            case 2: return getDeclaredIdentifiers_LSR3();
            case 3: return getDeclaredIdentifiers_LSR4();
            case 4: return getDeclaredIdentifiers_LSR5();
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
            case 0: setObject_LSR1(declIndex, value); break;
            case 1: setObject_LSR2(declIndex, value); break;
            case 2: setObject_LSR3(declIndex, value); break;
            case 3: setObject_LSR4(declIndex, value); break;
            case 4: setObject_LSR5(declIndex, value); break;
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
            case 0: return getObject_LSR1(declIndex);
            case 1: return getObject_LSR2(declIndex);
            case 2: return getObject_LSR3(declIndex);
            case 3: return getObject_LSR4(declIndex);
            case 4: return getObject_LSR5(declIndex);
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
            case 0: return getObjects_LSR1();
            case 1: return getObjects_LSR2();
            case 2: return getObjects_LSR3();
            case 3: return getObjects_LSR4();
            case 4: return getObjects_LSR5();
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
            case 0: setObjects_LSR1(objects); break;
            case 1: setObjects_LSR2(objects); break;
            case 2: setObjects_LSR3(objects); break;
            case 3: setObjects_LSR4(objects); break;
            case 4: setObjects_LSR5(objects); break;
        }
    }

    /*
     * The variables declared in the rules.
     */
    private sss.scheduler.objects.Lesson sss_scheduler_objects_Lesson_1;
    private sss.scheduler.objects.Schedule sss_scheduler_objects_Schedule_1;

    /**
     * Class constructor.
     *
     * @param knowledgeBase the knowledge base that contains this rule base.
     */
    public Jeops_RuleBase_LessonSelectionKB(jeops.AbstractKnowledgeBase knowledgeBase) {
        super(knowledgeBase);
    }

}
/**
 * Knowledge base created by JEOPS from file LessonSelectionKB.rules
 *
 * @version Jan 30, 2014
 */
public class LessonSelectionKB extends jeops.AbstractKnowledgeBase {

    /**
     * Creates a new knowledge base with the specified conflict set with the
     * desired conflict resolution policy.
     *
     * @param conflictSet a conflict set with the desired resolution policy
     */
    public LessonSelectionKB(jeops.conflict.ConflictSet conflictSet) {
        super(conflictSet);
    }

    /**
     * Creates a new knowledge base, using the default conflict resolution
     * policy.
     */
    public LessonSelectionKB() {
        this(new jeops.conflict.DefaultConflictSet());
    }

    /**
     * Factory method used to instantiate the rule base.
     */
    protected jeops.AbstractRuleBase createRuleBase() {
        return new Jeops_RuleBase_LessonSelectionKB(this);
    }

}
