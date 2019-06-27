class HelloWorldActionHandler implements EventListener<HelloWorldAction> {
    public void update(HelloWorldAction event) {
        System.out.println("HelloWorldAction triggered.");
    }
}