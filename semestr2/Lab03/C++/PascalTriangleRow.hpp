class PascalTriangleRow{
    private:
        int* C;
        int min(int x, int y);
        void calcPascalRow(int n, int k);
    
    public:
        int pascalValue(int k);

        PascalTriangleRow(int n);
        ~PascalTriangleRow();


};