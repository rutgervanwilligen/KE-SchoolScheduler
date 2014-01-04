package sss.reasoner;

import sss.scheduler.objects.Lesson;
import sss.scheduler.objects.Schedule;
import sss.scheduler.objects.Teacher;
import sss.scheduler.objects.LessonHour;
import sss.scheduler.objects.Classroom;
import sss.scheduler.objects.Availability;
import sss.scheduler.objects.ClassInSchool;

/**
 * Rule base used to allocate a lesson object to a classroom and time slot.
 */
  class Jeops_RuleBase_ClassroomTimeslotAllocationKB extends jeops.AbstractRuleBase {
  
  
    /**
     * Identifiers of rule allocationRule1
     */
    private String[] identifiers_allocationRule1 = {
        "schedule",
        "lessonToAllocate",
        "classroom",
        "hour",
        "teacher"
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
            case 4: return "sss.scheduler.objects.Teacher";
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
            case 4: return sss.scheduler.objects.Teacher.class;
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
            case 4: this.sss_scheduler_objects_Teacher_1 = (sss.scheduler.objects.Teacher) value; break;
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
            case 4: return sss_scheduler_objects_Teacher_1;
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
                            sss_scheduler_objects_LessonHour_1,
                            sss_scheduler_objects_Teacher_1
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
        sss_scheduler_objects_Teacher_1 = (sss.scheduler.objects.Teacher) objects[4];
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
     * <code>classroom.isAvailable(hour)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule1_cond_2() {
        return (sss_scheduler_objects_Classroom_1.isAvailable(sss_scheduler_objects_LessonHour_1));
    }

    /**
     * Condition 3 of rule allocationRule1.<p>
     * The original expression was:<br>
     * <code>classToAllocate.isAvailable(hour)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule1_cond_3() {
        return ((sss_scheduler_objects_Lesson_1.getClassInSchool()).isAvailable(sss_scheduler_objects_LessonHour_1));
    }

    /**
     * Condition 4 of rule allocationRule1.<p>
     * The original expression was:<br>
     * <code>teacher.getAvailability(hour) == Availability.AVAILABLE</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule1_cond_4() {
        return (sss_scheduler_objects_Teacher_1.getAvailability(sss_scheduler_objects_LessonHour_1) == Availability.AVAILABLE);
    }

    /**
     * Condition 5 of rule allocationRule1.<p>
     * The original expression was:<br>
     * <code>teacher.getScheduledValue(hour) == Availability.AVAILABLE</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean allocationRule1_cond_5() {
        return (sss_scheduler_objects_Teacher_1.getScheduledValue(sss_scheduler_objects_LessonHour_1) == Availability.AVAILABLE);
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
                return true;
            case 4:
                if (!allocationRule1_cond_4()) return false;
                if (!allocationRule1_cond_5()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule allocationRule1
     */
    private void allocationRule1() {
      System.out.println("allocationRule1 fired " + sss_scheduler_objects_Lesson_1.getSubject().getName());
  	  sss_scheduler_objects_Schedule_1.schedule(sss_scheduler_objects_Lesson_1, sss_scheduler_objects_Classroom_1, sss_scheduler_objects_LessonHour_1);
  	  sss_scheduler_objects_Classroom_1.setToUnavailable(sss_scheduler_objects_LessonHour_1);
  	  (sss_scheduler_objects_Lesson_1.getClassInSchool()).setToUnavailable(sss_scheduler_objects_LessonHour_1);
  	  sss_scheduler_objects_Teacher_1.setToUnavailable(sss_scheduler_objects_LessonHour_1);
  	  modified(sss_scheduler_objects_Schedule_1);
  	  modified(sss_scheduler_objects_Classroom_1);
  	  modified((sss_scheduler_objects_Lesson_1.getClassInSchool()));
  	  modified(sss_scheduler_objects_Teacher_1);
      }



    /**
     * The names of the rules in this class file
     */
    private static final String[] File_ruleNames = {
        "allocationRule1"
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
        5
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
            case 0: return allocationRule1_cond(condIndex);
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
        }
    }

    /**
     * Returns the number of rules.
     *
     * @return the number of rules.
     */
    public int getNumberOfRules() {
        return 1;
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
        }
    }

    /*
     * The variables declared in the rules.
     */
    private sss.scheduler.objects.Schedule sss_scheduler_objects_Schedule_1;
    private sss.scheduler.objects.Lesson sss_scheduler_objects_Lesson_1;
    private sss.scheduler.objects.Classroom sss_scheduler_objects_Classroom_1;
    private sss.scheduler.objects.LessonHour sss_scheduler_objects_LessonHour_1;
    private sss.scheduler.objects.Teacher sss_scheduler_objects_Teacher_1;

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
 * @version Jan 4, 2014
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
