class modernAdapter implements TurboPayment{

    private ModernPayment modern;

    /**
     * Redirect turbo parameters to modern.pay method
     * @param turboCardNo
     * @param turboAmount
     * @param destinationTurboOfCourse
     * @param installmentsButInTurbo
     * @return
     */
    public int payInTurbo(String turboCardNo, float turboAmount, String destinationTurboOfCourse, String installmentsButInTurbo) {
        return modern.pay(turboCardNo,turboAmount,destinationTurboOfCourse,installmentsButInTurbo);
    }

    /**
     * Assign an object to modern
     * @param modern
     */
    public modernAdapter(ModernPayment modern){
        this.modern = modern;
    }


}
