class PushAction extends Action {

    private ManagedThread mt;
    private Action a;

    public PushAction(ManagedThread mt, Action a) {
        this.mt = mt;
        this.a = a;
    }

    public void execute() {
        this.mt.add(a);
    }
}