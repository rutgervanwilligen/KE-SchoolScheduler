package sss.reasoner;

import sss.scheduler.objects.*;
import sss.scheduler.properties.Availability;
import sss.reasoner.penaltyObjects.*;

/**
 * Rule base used to optimize a schedule.
 */
  class Jeops_RuleBase_ScheduleOptimizationKB extends jeops.AbstractRuleBase {

	/**
	 * Rules for Teachers
	 */
	 
  
    /**
     * Identifiers of rule TeacherWalkingRule1
     */
    private String[] identifiers_TeacherWalkingRule1 = {
        "penalty",
        "schedule",
        "alternativeClassroom",
        "lessonInTheWay"
    };

    /**
     * Returns the identifiers declared in rule TeacherWalkingRule1
     *
     * @return the identifiers declared in rule TeacherWalkingRule1
     */
    private String[] getDeclaredIdentifiers_TeacherWalkingRule1() {
         return identifiers_TeacherWalkingRule1;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule TeacherWalkingRule1.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_TeacherWalkingRule1(int index) {
        switch (index) {
            case 0: return "sss.reasoner.penaltyObjects.PenaltyTeacherWalking";
            case 1: return "sss.scheduler.objects.Schedule";
            case 2: return "sss.scheduler.objects.Classroom";
            case 3: return "sss.scheduler.objects.Lesson";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule TeacherWalkingRule1.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_TeacherWalkingRule1(int index) {
        switch (index) {
            case 0: return sss.reasoner.penaltyObjects.PenaltyTeacherWalking.class;
            case 1: return sss.scheduler.objects.Schedule.class;
            case 2: return sss.scheduler.objects.Classroom.class;
            case 3: return sss.scheduler.objects.Lesson.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule TeacherWalkingRule1.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_TeacherWalkingRule1(int index, Object value) {
        switch (index) {
            case 0: this.sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1 = (sss.reasoner.penaltyObjects.PenaltyTeacherWalking) value; break;
            case 1: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 2: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
            case 3: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
        }
    }

    /**
     * Returns an object declared in the rule TeacherWalkingRule1.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_TeacherWalkingRule1(int index) {
        switch (index) {
            case 0: return sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1;
            case 1: return sss_scheduler_objects_Schedule_1;
            case 2: return sss_scheduler_objects_Classroom_1;
            case 3: return sss_scheduler_objects_Lesson_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule TeacherWalkingRule1
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_TeacherWalkingRule1() {
        return new Object[] {
                            sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1,
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Classroom_1,
                            sss_scheduler_objects_Lesson_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule TeacherWalkingRule1
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_TeacherWalkingRule1(Object[] objects) {
        sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1 = (sss.reasoner.penaltyObjects.PenaltyTeacherWalking) objects[0];
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[1];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[2];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[3];
    }

    /**
     * Condition 0 of rule TeacherWalkingRule1.<p>
     * The original expression was:<br>
     * <code>alternativeClassroom.isAvailable(lessonInTheWay.getHour(), lessonInTheWay)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean TeacherWalkingRule1_cond_0() {
        return (sss_scheduler_objects_Classroom_1.isAvailable(sss_scheduler_objects_Lesson_1.getHour(), sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 1 of rule TeacherWalkingRule1.<p>
     * The original expression was:<br>
     * <code>alternativeClassroom.isSuitedFor(lessonInTheWay)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean TeacherWalkingRule1_cond_1() {
        return (sss_scheduler_objects_Classroom_1.isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 2 of rule TeacherWalkingRule1.<p>
     * The original expression was:<br>
     * <code>lessonInTheWay.getHour().equals(lesson2.getHour())</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean TeacherWalkingRule1_cond_2() {
        return (sss_scheduler_objects_Lesson_1.getHour().equals((sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson2).getHour()));
    }

    /**
     * Condition 3 of rule TeacherWalkingRule1.<p>
     * The original expression was:<br>
     * <code>lessonInTheWay.getClassroom().equals(lesson1.getClassroom())</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean TeacherWalkingRule1_cond_3() {
        return (sss_scheduler_objects_Lesson_1.getClassroom().equals((sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson1).getClassroom()));
    }

    /**
     * Condition 4 of rule TeacherWalkingRule1.<p>
     * The original expression was:<br>
     * <code>lesson1.getClassroom().isSuitedFor(lesson2)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean TeacherWalkingRule1_cond_4() {
        return ((sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson1).getClassroom().isSuitedFor((sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson2)));
    }

    /**
     * Checks whether some conditions of rule TeacherWalkingRule1 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean TeacherWalkingRule1_cond(int index) {
        switch (index) {
            case 0: return TeacherWalkingRule1_cond_0();
            case 1: return TeacherWalkingRule1_cond_1();
            case 2: return TeacherWalkingRule1_cond_2();
            case 3: return TeacherWalkingRule1_cond_3();
            case 4: return TeacherWalkingRule1_cond_4();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule TeacherWalkingRule1 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_TeacherWalkingRule1(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!TeacherWalkingRule1_cond_4()) return false;
                return true;
            case 1:
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
    private boolean checkCondForDeclaration_TeacherWalkingRule1(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                if (!TeacherWalkingRule1_cond_0()) return false;
                if (!TeacherWalkingRule1_cond_1()) return false;
                if (!TeacherWalkingRule1_cond_2()) return false;
                if (!TeacherWalkingRule1_cond_3()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule TeacherWalkingRule1
     */
    private void TeacherWalkingRule1() {
      sss_scheduler_objects_Schedule_1.moveLesson(sss_scheduler_objects_Lesson_1, sss_scheduler_objects_Lesson_1.getHour(), sss_scheduler_objects_Classroom_1);
      sss_scheduler_objects_Schedule_1.moveLesson((sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson2), (sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson2).getHour(), (sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson1).getClassroom());
      System.out.println("TeacherWalkingRule1 fired.");
      retract(sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1);
      retract(sss_scheduler_objects_Schedule_1);
      }


	 
  
    /**
     * Identifiers of rule TeacherWalkingRule2
     */
    private String[] identifiers_TeacherWalkingRule2 = {
        "penalty",
        "schedule",
        "lessonInTheWay"
    };

    /**
     * Returns the identifiers declared in rule TeacherWalkingRule2
     *
     * @return the identifiers declared in rule TeacherWalkingRule2
     */
    private String[] getDeclaredIdentifiers_TeacherWalkingRule2() {
         return identifiers_TeacherWalkingRule2;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule TeacherWalkingRule2.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_TeacherWalkingRule2(int index) {
        switch (index) {
            case 0: return "sss.reasoner.penaltyObjects.PenaltyTeacherWalking";
            case 1: return "sss.scheduler.objects.Schedule";
            case 2: return "sss.scheduler.objects.Lesson";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule TeacherWalkingRule2.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_TeacherWalkingRule2(int index) {
        switch (index) {
            case 0: return sss.reasoner.penaltyObjects.PenaltyTeacherWalking.class;
            case 1: return sss.scheduler.objects.Schedule.class;
            case 2: return sss.scheduler.objects.Lesson.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule TeacherWalkingRule2.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_TeacherWalkingRule2(int index, Object value) {
        switch (index) {
            case 0: this.sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1 = (sss.reasoner.penaltyObjects.PenaltyTeacherWalking) value; break;
            case 1: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 2: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
        }
    }

    /**
     * Returns an object declared in the rule TeacherWalkingRule2.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_TeacherWalkingRule2(int index) {
        switch (index) {
            case 0: return sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1;
            case 1: return sss_scheduler_objects_Schedule_1;
            case 2: return sss_scheduler_objects_Lesson_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule TeacherWalkingRule2
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_TeacherWalkingRule2() {
        return new Object[] {
                            sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1,
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule TeacherWalkingRule2
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_TeacherWalkingRule2(Object[] objects) {
        sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1 = (sss.reasoner.penaltyObjects.PenaltyTeacherWalking) objects[0];
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[1];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[2];
    }

    /**
     * Condition 0 of rule TeacherWalkingRule2.<p>
     * The original expression was:<br>
     * <code>lessonInTheWay.getHour().equals(lesson2.getHour())</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean TeacherWalkingRule2_cond_0() {
        return (sss_scheduler_objects_Lesson_1.getHour().equals((sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson2).getHour()));
    }

    /**
     * Condition 1 of rule TeacherWalkingRule2.<p>
     * The original expression was:<br>
     * <code>lessonInTheWay.getClassroom().equals(lesson1.getClassroom())</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean TeacherWalkingRule2_cond_1() {
        return (sss_scheduler_objects_Lesson_1.getClassroom().equals((sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson1).getClassroom()));
    }

    /**
     * Condition 2 of rule TeacherWalkingRule2.<p>
     * The original expression was:<br>
     * <code>lesson1.getClassroom().isSuitedFor(lesson2)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean TeacherWalkingRule2_cond_2() {
        return ((sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson1).getClassroom().isSuitedFor((sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson2)));
    }

    /**
     * Condition 3 of rule TeacherWalkingRule2.<p>
     * The original expression was:<br>
     * <code>lesson1.getClassroom().isAvailable(lesson2.getHour(), lesson2)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean TeacherWalkingRule2_cond_3() {
        return ((sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson1).getClassroom().isAvailable((sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson2).getHour(), (sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson2)));
    }

    /**
     * Checks whether some conditions of rule TeacherWalkingRule2 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean TeacherWalkingRule2_cond(int index) {
        switch (index) {
            case 0: return TeacherWalkingRule2_cond_0();
            case 1: return TeacherWalkingRule2_cond_1();
            case 2: return TeacherWalkingRule2_cond_2();
            case 3: return TeacherWalkingRule2_cond_3();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule TeacherWalkingRule2 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_TeacherWalkingRule2(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!TeacherWalkingRule2_cond_2()) return false;
                if (!TeacherWalkingRule2_cond_3()) return false;
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
    private boolean checkCondForDeclaration_TeacherWalkingRule2(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                if (!TeacherWalkingRule2_cond_0()) return false;
                if (!TeacherWalkingRule2_cond_1()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule TeacherWalkingRule2
     */
    private void TeacherWalkingRule2() {
      sss_scheduler_objects_Schedule_1.moveLesson((sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson2), (sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson2).getHour(), (sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson1).getClassroom());
      System.out.println("TeacherWalkingRule1 fired.");
      retract(sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1);
      retract(sss_scheduler_objects_Schedule_1);
      }


	 
  
    /**
     * Identifiers of rule TeacherRatherNot1
     */
    private String[] identifiers_TeacherRatherNot1 = {
        "penalty",
        "schedule",
        "lesson",
        "lessonHour2"
    };

    /**
     * Returns the identifiers declared in rule TeacherRatherNot1
     *
     * @return the identifiers declared in rule TeacherRatherNot1
     */
    private String[] getDeclaredIdentifiers_TeacherRatherNot1() {
         return identifiers_TeacherRatherNot1;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule TeacherRatherNot1.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_TeacherRatherNot1(int index) {
        switch (index) {
            case 0: return "sss.reasoner.penaltyObjects.PenaltyTeacherRatherNot";
            case 1: return "sss.scheduler.objects.Schedule";
            case 2: return "sss.scheduler.objects.Lesson";
            case 3: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule TeacherRatherNot1.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_TeacherRatherNot1(int index) {
        switch (index) {
            case 0: return sss.reasoner.penaltyObjects.PenaltyTeacherRatherNot.class;
            case 1: return sss.scheduler.objects.Schedule.class;
            case 2: return sss.scheduler.objects.Lesson.class;
            case 3: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule TeacherRatherNot1.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_TeacherRatherNot1(int index, Object value) {
        switch (index) {
            case 0: this.sss_reasoner_penaltyObjects_PenaltyTeacherRatherNot_1 = (sss.reasoner.penaltyObjects.PenaltyTeacherRatherNot) value; break;
            case 1: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 2: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 3: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule TeacherRatherNot1.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_TeacherRatherNot1(int index) {
        switch (index) {
            case 0: return sss_reasoner_penaltyObjects_PenaltyTeacherRatherNot_1;
            case 1: return sss_scheduler_objects_Schedule_1;
            case 2: return sss_scheduler_objects_Lesson_1;
            case 3: return sss_scheduler_objects_LessonHour_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule TeacherRatherNot1
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_TeacherRatherNot1() {
        return new Object[] {
                            sss_reasoner_penaltyObjects_PenaltyTeacherRatherNot_1,
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule TeacherRatherNot1
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_TeacherRatherNot1(Object[] objects) {
        sss_reasoner_penaltyObjects_PenaltyTeacherRatherNot_1 = (sss.reasoner.penaltyObjects.PenaltyTeacherRatherNot) objects[0];
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[1];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[2];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[3];
    }

    /**
     * Condition 0 of rule TeacherRatherNot1.<p>
     * The original expression was:<br>
     * <code>lesson.getTeacher().equals(teacher)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean TeacherRatherNot1_cond_0() {
        return (sss_scheduler_objects_Lesson_1.getTeacher().equals((sss_reasoner_penaltyObjects_PenaltyTeacherRatherNot_1.teacher)));
    }

    /**
     * Condition 1 of rule TeacherRatherNot1.<p>
     * The original expression was:<br>
     * <code>lesson.getHour().equals(lessonHour1)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean TeacherRatherNot1_cond_1() {
        return (sss_scheduler_objects_Lesson_1.getHour().equals((sss_reasoner_penaltyObjects_PenaltyTeacherRatherNot_1.lessonHour)));
    }

    /**
     * Condition 2 of rule TeacherRatherNot1.<p>
     * The original expression was:<br>
     * <code>teacher.getAvailability(lessonHour2).equals(Availability.AVAILABLE)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean TeacherRatherNot1_cond_2() {
        return ((sss_reasoner_penaltyObjects_PenaltyTeacherRatherNot_1.teacher).getAvailability(sss_scheduler_objects_LessonHour_1).equals(Availability.AVAILABLE));
    }

    /**
     * Condition 3 of rule TeacherRatherNot1.<p>
     * The original expression was:<br>
     * <code>!teacher.isScheduled(lessonHour2, lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean TeacherRatherNot1_cond_3() {
        return (!(sss_reasoner_penaltyObjects_PenaltyTeacherRatherNot_1.teacher).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 4 of rule TeacherRatherNot1.<p>
     * The original expression was:<br>
     * <code>classroom.isAvailable(lessonHour2, lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean TeacherRatherNot1_cond_4() {
        return ((sss_scheduler_objects_Lesson_1.getClassroom()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 5 of rule TeacherRatherNot1.<p>
     * The original expression was:<br>
     * <code>classroom.isSuitedFor(lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean TeacherRatherNot1_cond_5() {
        return ((sss_scheduler_objects_Lesson_1.getClassroom()).isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 6 of rule TeacherRatherNot1.<p>
     * The original expression was:<br>
     * <code>classInSchool.isAvailable(lessonHour2, lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean TeacherRatherNot1_cond_6() {
        return ((sss_scheduler_objects_Lesson_1.getClassInSchool()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Checks whether some conditions of rule TeacherRatherNot1 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean TeacherRatherNot1_cond(int index) {
        switch (index) {
            case 0: return TeacherRatherNot1_cond_0();
            case 1: return TeacherRatherNot1_cond_1();
            case 2: return TeacherRatherNot1_cond_2();
            case 3: return TeacherRatherNot1_cond_3();
            case 4: return TeacherRatherNot1_cond_4();
            case 5: return TeacherRatherNot1_cond_5();
            case 6: return TeacherRatherNot1_cond_6();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule TeacherRatherNot1 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_TeacherRatherNot1(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                if (!TeacherRatherNot1_cond_5()) return false;
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
    private boolean checkCondForDeclaration_TeacherRatherNot1(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                if (!TeacherRatherNot1_cond_0()) return false;
                if (!TeacherRatherNot1_cond_1()) return false;
                return true;
            case 3:
                if (!TeacherRatherNot1_cond_2()) return false;
                if (!TeacherRatherNot1_cond_3()) return false;
                if (!TeacherRatherNot1_cond_4()) return false;
                if (!TeacherRatherNot1_cond_6()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule TeacherRatherNot1
     */
    private void TeacherRatherNot1() {
      sss_scheduler_objects_Schedule_1.moveLesson(sss_scheduler_objects_Lesson_1, sss_scheduler_objects_LessonHour_1, (sss_scheduler_objects_Lesson_1.getClassroom()));
      System.out.println("TeacherRatherNot1 fired.");
      retract(sss_reasoner_penaltyObjects_PenaltyTeacherRatherNot_1);
      retract(sss_scheduler_objects_Schedule_1);
      }



	/**
	 * Rules for Classes
	 */
	 
  
    /**
     * Identifiers of rule Class9thHourRule1
     */
    private String[] identifiers_Class9thHourRule1 = {
        "penalty",
        "schedule",
        "alternativeLessonHour",
        "alternativeClassroom",
        "lesson"
    };

    /**
     * Returns the identifiers declared in rule Class9thHourRule1
     *
     * @return the identifiers declared in rule Class9thHourRule1
     */
    private String[] getDeclaredIdentifiers_Class9thHourRule1() {
         return identifiers_Class9thHourRule1;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule Class9thHourRule1.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_Class9thHourRule1(int index) {
        switch (index) {
            case 0: return "sss.reasoner.penaltyObjects.PenaltyClass9thHour";
            case 1: return "sss.scheduler.objects.Schedule";
            case 2: return "sss.scheduler.objects.LessonHour";
            case 3: return "sss.scheduler.objects.Classroom";
            case 4: return "sss.scheduler.objects.Lesson";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule Class9thHourRule1.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_Class9thHourRule1(int index) {
        switch (index) {
            case 0: return sss.reasoner.penaltyObjects.PenaltyClass9thHour.class;
            case 1: return sss.scheduler.objects.Schedule.class;
            case 2: return sss.scheduler.objects.LessonHour.class;
            case 3: return sss.scheduler.objects.Classroom.class;
            case 4: return sss.scheduler.objects.Lesson.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule Class9thHourRule1.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_Class9thHourRule1(int index, Object value) {
        switch (index) {
            case 0: this.sss_reasoner_penaltyObjects_PenaltyClass9thHour_1 = (sss.reasoner.penaltyObjects.PenaltyClass9thHour) value; break;
            case 1: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 2: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
            case 3: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
            case 4: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
        }
    }

    /**
     * Returns an object declared in the rule Class9thHourRule1.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_Class9thHourRule1(int index) {
        switch (index) {
            case 0: return sss_reasoner_penaltyObjects_PenaltyClass9thHour_1;
            case 1: return sss_scheduler_objects_Schedule_1;
            case 2: return sss_scheduler_objects_LessonHour_1;
            case 3: return sss_scheduler_objects_Classroom_1;
            case 4: return sss_scheduler_objects_Lesson_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule Class9thHourRule1
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_Class9thHourRule1() {
        return new Object[] {
                            sss_reasoner_penaltyObjects_PenaltyClass9thHour_1,
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_LessonHour_1,
                            sss_scheduler_objects_Classroom_1,
                            sss_scheduler_objects_Lesson_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule Class9thHourRule1
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_Class9thHourRule1(Object[] objects) {
        sss_reasoner_penaltyObjects_PenaltyClass9thHour_1 = (sss.reasoner.penaltyObjects.PenaltyClass9thHour) objects[0];
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[1];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[2];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[3];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[4];
    }

    /**
     * Condition 0 of rule Class9thHourRule1.<p>
     * The original expression was:<br>
     * <code>lesson.getHour().equals(lessonHour)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean Class9thHourRule1_cond_0() {
        return (sss_scheduler_objects_Lesson_1.getHour().equals((sss_reasoner_penaltyObjects_PenaltyClass9thHour_1.lessonHour)));
    }

    /**
     * Condition 1 of rule Class9thHourRule1.<p>
     * The original expression was:<br>
     * <code>lesson.getClassInSchool().equals(classInSchool)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean Class9thHourRule1_cond_1() {
        return (sss_scheduler_objects_Lesson_1.getClassInSchool().equals((sss_reasoner_penaltyObjects_PenaltyClass9thHour_1.classInSchool)));
    }

    /**
     * Condition 2 of rule Class9thHourRule1.<p>
     * The original expression was:<br>
     * <code>teacher.isAvailable(alternativeLessonHour, lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean Class9thHourRule1_cond_2() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 3 of rule Class9thHourRule1.<p>
     * The original expression was:<br>
     * <code>!teacher.isScheduled(alternativeLessonHour, lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean Class9thHourRule1_cond_3() {
        return (!(sss_scheduler_objects_Lesson_1.getTeacher()).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 4 of rule Class9thHourRule1.<p>
     * The original expression was:<br>
     * <code>classInSchool.isAvailable(alternativeLessonHour, lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean Class9thHourRule1_cond_4() {
        return ((sss_reasoner_penaltyObjects_PenaltyClass9thHour_1.classInSchool).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 5 of rule Class9thHourRule1.<p>
     * The original expression was:<br>
     * <code>alternativeClassroom.isAvailable(alternativeLessonHour, lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean Class9thHourRule1_cond_5() {
        return (sss_scheduler_objects_Classroom_1.isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Checks whether some conditions of rule Class9thHourRule1 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean Class9thHourRule1_cond(int index) {
        switch (index) {
            case 0: return Class9thHourRule1_cond_0();
            case 1: return Class9thHourRule1_cond_1();
            case 2: return Class9thHourRule1_cond_2();
            case 3: return Class9thHourRule1_cond_3();
            case 4: return Class9thHourRule1_cond_4();
            case 5: return Class9thHourRule1_cond_5();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule Class9thHourRule1 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_Class9thHourRule1(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                return true;
            case 4:
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
    private boolean checkCondForDeclaration_Class9thHourRule1(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                return true;
            case 4:
                if (!Class9thHourRule1_cond_0()) return false;
                if (!Class9thHourRule1_cond_1()) return false;
                if (!Class9thHourRule1_cond_2()) return false;
                if (!Class9thHourRule1_cond_3()) return false;
                if (!Class9thHourRule1_cond_4()) return false;
                if (!Class9thHourRule1_cond_5()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule Class9thHourRule1
     */
    private void Class9thHourRule1() {
      sss_scheduler_objects_Schedule_1.moveLesson(sss_scheduler_objects_Lesson_1, sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Classroom_1);
      retract(sss_reasoner_penaltyObjects_PenaltyClass9thHour_1);
      retract(sss_scheduler_objects_Schedule_1);
      System.out.println("Class9thHourRule1 fired for " + sss_scheduler_objects_Lesson_1.getClassInSchool().getName() + " at " + sss_scheduler_objects_Lesson_1.getHour().getWeekday());
      }


	 
  
    /**
     * Identifiers of rule ClassBetweenHoursRule1
     */
    private String[] identifiers_ClassBetweenHoursRule1 = {
        "penalty",
        "schedule",
        "lessonHour1",
        "lessonHour2",
        "lesson",
        "classroom"
    };

    /**
     * Returns the identifiers declared in rule ClassBetweenHoursRule1
     *
     * @return the identifiers declared in rule ClassBetweenHoursRule1
     */
    private String[] getDeclaredIdentifiers_ClassBetweenHoursRule1() {
         return identifiers_ClassBetweenHoursRule1;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule ClassBetweenHoursRule1.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_ClassBetweenHoursRule1(int index) {
        switch (index) {
            case 0: return "sss.reasoner.penaltyObjects.PenaltyClassBetweenHours";
            case 1: return "sss.scheduler.objects.Schedule";
            case 2: return "sss.scheduler.objects.LessonHour";
            case 3: return "sss.scheduler.objects.LessonHour";
            case 4: return "sss.scheduler.objects.Lesson";
            case 5: return "sss.scheduler.objects.Classroom";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule ClassBetweenHoursRule1.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_ClassBetweenHoursRule1(int index) {
        switch (index) {
            case 0: return sss.reasoner.penaltyObjects.PenaltyClassBetweenHours.class;
            case 1: return sss.scheduler.objects.Schedule.class;
            case 2: return sss.scheduler.objects.LessonHour.class;
            case 3: return sss.scheduler.objects.LessonHour.class;
            case 4: return sss.scheduler.objects.Lesson.class;
            case 5: return sss.scheduler.objects.Classroom.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule ClassBetweenHoursRule1.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_ClassBetweenHoursRule1(int index, Object value) {
        switch (index) {
            case 0: this.sss_reasoner_penaltyObjects_PenaltyClassBetweenHours_1 = (sss.reasoner.penaltyObjects.PenaltyClassBetweenHours) value; break;
            case 1: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 2: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
            case 3: this.sss_scheduler_objects_LessonHour_2 = (sss.scheduler.objects.LessonHour) value; break;
            case 4: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 5: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
        }
    }

    /**
     * Returns an object declared in the rule ClassBetweenHoursRule1.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_ClassBetweenHoursRule1(int index) {
        switch (index) {
            case 0: return sss_reasoner_penaltyObjects_PenaltyClassBetweenHours_1;
            case 1: return sss_scheduler_objects_Schedule_1;
            case 2: return sss_scheduler_objects_LessonHour_1;
            case 3: return sss_scheduler_objects_LessonHour_2;
            case 4: return sss_scheduler_objects_Lesson_1;
            case 5: return sss_scheduler_objects_Classroom_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule ClassBetweenHoursRule1
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_ClassBetweenHoursRule1() {
        return new Object[] {
                            sss_reasoner_penaltyObjects_PenaltyClassBetweenHours_1,
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_LessonHour_1,
                            sss_scheduler_objects_LessonHour_2,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Classroom_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule ClassBetweenHoursRule1
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_ClassBetweenHoursRule1(Object[] objects) {
        sss_reasoner_penaltyObjects_PenaltyClassBetweenHours_1 = (sss.reasoner.penaltyObjects.PenaltyClassBetweenHours) objects[0];
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[1];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[2];
        sss_scheduler_objects_LessonHour_2 = (sss.scheduler.objects.LessonHour) objects[3];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[4];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[5];
    }

    /**
     * Condition 0 of rule ClassBetweenHoursRule1.<p>
     * The original expression was:<br>
     * <code>teacher.isAvailable(lessonHour1, lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean ClassBetweenHoursRule1_cond_0() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 1 of rule ClassBetweenHoursRule1.<p>
     * The original expression was:<br>
     * <code>!teacher.isScheduled(lessonHour1, lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean ClassBetweenHoursRule1_cond_1() {
        return (!(sss_scheduler_objects_Lesson_1.getTeacher()).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 2 of rule ClassBetweenHoursRule1.<p>
     * The original expression was:<br>
     * <code>classroom.isAvailable(lessonHour1, lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean ClassBetweenHoursRule1_cond_2() {
        return (sss_scheduler_objects_Classroom_1.isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 3 of rule ClassBetweenHoursRule1.<p>
     * The original expression was:<br>
     * <code>classInSchool.hasBetweenHourOn(lessonHour1)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean ClassBetweenHoursRule1_cond_3() {
        return ((sss_reasoner_penaltyObjects_PenaltyClassBetweenHours_1.classInSchool).hasBetweenHourOn(sss_scheduler_objects_LessonHour_1));
    }

    /**
     * Condition 4 of rule ClassBetweenHoursRule1.<p>
     * The original expression was:<br>
     * <code>classInSchool.hasStartOrEndingHour(lessonHour2)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean ClassBetweenHoursRule1_cond_4() {
        return ((sss_reasoner_penaltyObjects_PenaltyClassBetweenHours_1.classInSchool).hasStartOrEndingHour(sss_scheduler_objects_LessonHour_2));
    }

    /**
     * Condition 5 of rule ClassBetweenHoursRule1.<p>
     * The original expression was:<br>
     * <code>lesson.getHour().equals(lessonHour2)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean ClassBetweenHoursRule1_cond_5() {
        return (sss_scheduler_objects_Lesson_1.getHour().equals(sss_scheduler_objects_LessonHour_2));
    }

    /**
     * Checks whether some conditions of rule ClassBetweenHoursRule1 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean ClassBetweenHoursRule1_cond(int index) {
        switch (index) {
            case 0: return ClassBetweenHoursRule1_cond_0();
            case 1: return ClassBetweenHoursRule1_cond_1();
            case 2: return ClassBetweenHoursRule1_cond_2();
            case 3: return ClassBetweenHoursRule1_cond_3();
            case 4: return ClassBetweenHoursRule1_cond_4();
            case 5: return ClassBetweenHoursRule1_cond_5();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule ClassBetweenHoursRule1 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_ClassBetweenHoursRule1(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                return true;
            case 4:
                return true;
            case 5:
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
    private boolean checkCondForDeclaration_ClassBetweenHoursRule1(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                if (!ClassBetweenHoursRule1_cond_3()) return false;
                return true;
            case 3:
                if (!ClassBetweenHoursRule1_cond_4()) return false;
                return true;
            case 4:
                if (!ClassBetweenHoursRule1_cond_0()) return false;
                if (!ClassBetweenHoursRule1_cond_1()) return false;
                if (!ClassBetweenHoursRule1_cond_5()) return false;
                return true;
            case 5:
                if (!ClassBetweenHoursRule1_cond_2()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule ClassBetweenHoursRule1
     */
    private void ClassBetweenHoursRule1() {
      sss_scheduler_objects_Schedule_1.moveLesson(sss_scheduler_objects_Lesson_1, sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Classroom_1);
      retract(sss_reasoner_penaltyObjects_PenaltyClassBetweenHours_1);
      retract(sss_scheduler_objects_Schedule_1);
      System.out.println("ClassBetweenHoursRule1 fired for " + sss_scheduler_objects_Lesson_1.getClassInSchool().getName() + " at " + sss_scheduler_objects_Lesson_1.getHour().getWeekday());
      }


  

    /**
     * The names of the rules in this class file
     */
    private static final String[] File_ruleNames = {
        "TeacherWalkingRule1",
        "TeacherWalkingRule2",
        "TeacherRatherNot1",
        "Class9thHourRule1",
        "ClassBetweenHoursRule1"
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
        3,
        4,
        5,
        6
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
        4,
        7,
        6,
        6
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
            case 0: return TeacherWalkingRule1_cond(condIndex);
            case 1: return TeacherWalkingRule2_cond(condIndex);
            case 2: return TeacherRatherNot1_cond(condIndex);
            case 3: return Class9thHourRule1_cond(condIndex);
            case 4: return ClassBetweenHoursRule1_cond(condIndex);
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
            case 0: return checkConditionsOnlyOf_TeacherWalkingRule1(declIndex);
            case 1: return checkConditionsOnlyOf_TeacherWalkingRule2(declIndex);
            case 2: return checkConditionsOnlyOf_TeacherRatherNot1(declIndex);
            case 3: return checkConditionsOnlyOf_Class9thHourRule1(declIndex);
            case 4: return checkConditionsOnlyOf_ClassBetweenHoursRule1(declIndex);
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
            case 0: return checkCondForDeclaration_TeacherWalkingRule1(declIndex);
            case 1: return checkCondForDeclaration_TeacherWalkingRule2(declIndex);
            case 2: return checkCondForDeclaration_TeacherRatherNot1(declIndex);
            case 3: return checkCondForDeclaration_Class9thHourRule1(declIndex);
            case 4: return checkCondForDeclaration_ClassBetweenHoursRule1(declIndex);
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
            case 0: return getDeclaredClassName_TeacherWalkingRule1(declIndex);
            case 1: return getDeclaredClassName_TeacherWalkingRule2(declIndex);
            case 2: return getDeclaredClassName_TeacherRatherNot1(declIndex);
            case 3: return getDeclaredClassName_Class9thHourRule1(declIndex);
            case 4: return getDeclaredClassName_ClassBetweenHoursRule1(declIndex);
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
            case 0: return getDeclaredClass_TeacherWalkingRule1(declIndex);
            case 1: return getDeclaredClass_TeacherWalkingRule2(declIndex);
            case 2: return getDeclaredClass_TeacherRatherNot1(declIndex);
            case 3: return getDeclaredClass_Class9thHourRule1(declIndex);
            case 4: return getDeclaredClass_ClassBetweenHoursRule1(declIndex);
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
            case 0: TeacherWalkingRule1(); break;
            case 1: TeacherWalkingRule2(); break;
            case 2: TeacherRatherNot1(); break;
            case 3: Class9thHourRule1(); break;
            case 4: ClassBetweenHoursRule1(); break;
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
            case 0: return getDeclaredIdentifiers_TeacherWalkingRule1();
            case 1: return getDeclaredIdentifiers_TeacherWalkingRule2();
            case 2: return getDeclaredIdentifiers_TeacherRatherNot1();
            case 3: return getDeclaredIdentifiers_Class9thHourRule1();
            case 4: return getDeclaredIdentifiers_ClassBetweenHoursRule1();
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
            case 0: setObject_TeacherWalkingRule1(declIndex, value); break;
            case 1: setObject_TeacherWalkingRule2(declIndex, value); break;
            case 2: setObject_TeacherRatherNot1(declIndex, value); break;
            case 3: setObject_Class9thHourRule1(declIndex, value); break;
            case 4: setObject_ClassBetweenHoursRule1(declIndex, value); break;
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
            case 0: return getObject_TeacherWalkingRule1(declIndex);
            case 1: return getObject_TeacherWalkingRule2(declIndex);
            case 2: return getObject_TeacherRatherNot1(declIndex);
            case 3: return getObject_Class9thHourRule1(declIndex);
            case 4: return getObject_ClassBetweenHoursRule1(declIndex);
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
            case 0: return getObjects_TeacherWalkingRule1();
            case 1: return getObjects_TeacherWalkingRule2();
            case 2: return getObjects_TeacherRatherNot1();
            case 3: return getObjects_Class9thHourRule1();
            case 4: return getObjects_ClassBetweenHoursRule1();
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
            case 0: setObjects_TeacherWalkingRule1(objects); break;
            case 1: setObjects_TeacherWalkingRule2(objects); break;
            case 2: setObjects_TeacherRatherNot1(objects); break;
            case 3: setObjects_Class9thHourRule1(objects); break;
            case 4: setObjects_ClassBetweenHoursRule1(objects); break;
        }
    }

    /*
     * The variables declared in the rules.
     */
    private sss.reasoner.penaltyObjects.PenaltyTeacherWalking sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1;
    private sss.scheduler.objects.Schedule sss_scheduler_objects_Schedule_1;
    private sss.scheduler.objects.Classroom sss_scheduler_objects_Classroom_1;
    private sss.scheduler.objects.Lesson sss_scheduler_objects_Lesson_1;
    private sss.reasoner.penaltyObjects.PenaltyTeacherRatherNot sss_reasoner_penaltyObjects_PenaltyTeacherRatherNot_1;
    private sss.scheduler.objects.LessonHour sss_scheduler_objects_LessonHour_1;
    private sss.reasoner.penaltyObjects.PenaltyClass9thHour sss_reasoner_penaltyObjects_PenaltyClass9thHour_1;
    private sss.reasoner.penaltyObjects.PenaltyClassBetweenHours sss_reasoner_penaltyObjects_PenaltyClassBetweenHours_1;
    private sss.scheduler.objects.LessonHour sss_scheduler_objects_LessonHour_2;

    /**
     * Class constructor.
     *
     * @param knowledgeBase the knowledge base that contains this rule base.
     */
    public Jeops_RuleBase_ScheduleOptimizationKB(jeops.AbstractKnowledgeBase knowledgeBase) {
        super(knowledgeBase);
    }

}
/**
 * Knowledge base created by JEOPS from file ScheduleOptimizationKB.rules
 *
 * @version Jan 29, 2014
 */
public class ScheduleOptimizationKB extends jeops.AbstractKnowledgeBase {

    /**
     * Creates a new knowledge base with the specified conflict set with the
     * desired conflict resolution policy.
     *
     * @param conflictSet a conflict set with the desired resolution policy
     */
    public ScheduleOptimizationKB(jeops.conflict.ConflictSet conflictSet) {
        super(conflictSet);
    }

    /**
     * Creates a new knowledge base, using the default conflict resolution
     * policy.
     */
    public ScheduleOptimizationKB() {
        this(new jeops.conflict.DefaultConflictSet());
    }

    /**
     * Factory method used to instantiate the rule base.
     */
    protected jeops.AbstractRuleBase createRuleBase() {
        return new Jeops_RuleBase_ScheduleOptimizationKB(this);
    }

}
