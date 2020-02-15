{-# LANGUAGE OverloadedStrings #-}

module Bob (responseFor) where

import           Data.Char (isLower, isSpace, isUpper)
import           Data.Text (Text)
import qualified Data.Text as T

questionResponse, yellingResponse, yellingQuestionResponse, silenceReponse, defaultResponse :: Text
questionResponse        = "Sure."
yellingResponse         = "Whoa, chill out!"
yellingQuestionResponse = "Calm down, I know what I'm doing!"
silenceReponse          = "Fine. Be that way!"
defaultResponse         = "Whatever."

responseFor :: Text -> Text
responseFor t
    | yelling && question   = yellingQuestionResponse
    | yelling               = yellingResponse
    | question              = questionResponse
    | isSilence t           = silenceReponse
    | otherwise             = defaultResponse
    where yelling  = isYelling t
          question = isQuestion t

isQuestion :: Text -> Bool
isQuestion t = not (T.null strippedText) 
            && T.last strippedText == '?'
    where strippedText = T.stripEnd t

isYelling :: Text -> Bool
isYelling t = not (T.any isLower t) 
           && T.any isUpper t

isSilence :: Text -> Bool
isSilence = T.all isSpace
