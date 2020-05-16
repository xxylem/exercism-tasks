# frozen_string_literal: true

BAND_VALUES = { 'black' => 0, 'brown' => 1, 'red' => 2, 'orange' => 3, 'yellow' => 4,
                'green' => 5, 'blue' => 6, 'violet' => 7, 'grey' => 8, 'white' => 9 }.freeze

class ResistorColorDuo
  # Assumes at least two colors in bands
  def self.value(bands)
    BAND_VALUES[bands[0]] * 10 + BAND_VALUES[bands[1]]
  end
end
