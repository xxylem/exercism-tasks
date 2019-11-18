using System;

public struct ComplexNumber
{
    // These wouldn't have underscores if the public methods below didn't exist.
    private readonly double _Real;
    private readonly double _Imaginary;

    public ComplexNumber(double real, double imaginary)
    {
        _Real = real;
        _Imaginary = imaginary;
    }

    // I probably wouldn't have these public getters, but they're required for the test suite.
    public double Real() => _Real;
    public double Imaginary() => _Imaginary;

    public ComplexNumber Mul(ComplexNumber other) 
        => new ComplexNumber(
            _Real * other._Real - _Imaginary * other._Imaginary,
            _Imaginary * other._Real + _Real * other._Imaginary);

    public ComplexNumber Add(ComplexNumber other) 
        => new ComplexNumber(
            _Real + other._Real,
            _Imaginary + other._Imaginary);

    public ComplexNumber Sub(ComplexNumber other) 
        => new ComplexNumber(
            _Real - other._Real,
            _Imaginary - other._Imaginary);

    public ComplexNumber Div(ComplexNumber other)
    {
        double denominator = other._Real * other._Real + other._Imaginary * other._Imaginary;
        return new ComplexNumber(
            (_Real * other._Real + _Imaginary * other._Imaginary) / denominator,
            (_Imaginary * other._Real - _Real * other._Imaginary) / denominator);
    }

    public double Abs() => Math.Sqrt(_Real * _Real + _Imaginary * _Imaginary);

    public ComplexNumber Conjugate()
        => new ComplexNumber(
            _Real,
            -_Imaginary);

    public ComplexNumber Exp()
    {
        double e_to_a = Math.Exp(_Real);
        return new ComplexNumber(
            e_to_a * Math.Cos(_Imaginary),
            e_to_a * Math.Sin(_Imaginary));
    }
}